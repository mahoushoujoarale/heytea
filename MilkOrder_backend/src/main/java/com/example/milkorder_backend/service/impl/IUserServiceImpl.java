package com.example.milkorder_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.milkorder_backend.common.exception.ApiAsserts;
import com.example.milkorder_backend.jwt.JwtUtil;
import com.example.milkorder_backend.mapper.UserMapper;
import com.example.milkorder_backend.model.dto.LoginDTO;
import com.example.milkorder_backend.model.dto.RegisterDTO;
import com.example.milkorder_backend.model.entity.User;
import com.example.milkorder_backend.service.IUserService;
import com.example.milkorder_backend.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Date;

@Slf4j  // 日志
@Service  // 标记当前类是一个service类，加上该注解会将当前类自动注入到spring容器中，不需要再在applicationContext.xml文件定义bean了
@Transactional(rollbackFor = Exception.class)
public class IUserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService {
    // 1. 用户注册
    @Override
    public User executeRegister(RegisterDTO dto) {
        /**
         * 查询是否有相同用户名的用户
         */
        // 创建一个查询对象 wrapper，对应的的实体为 User
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        // 将wrapper的username和email字段分别设为dto中传入的数据
        wrapper.eq(User::getUsername, dto.getName()).or().eq(User::getEmail, dto.getEmail());
        // 用wrapper中的值匹配一个实体User对象
        User User = baseMapper.selectOne(wrapper);
        if (!ObjectUtils.isEmpty(User)) {
            // 匹配成功说明已存在
            ApiAsserts.fail("账号或邮箱已存在！");
        }
        // 否者，创建一个新增对象addUser依次设置字段值，然后插入表单
        User addUser = User.builder()
                .username(dto.getName())
                .password(MD5Utils.getPwd(dto.getPass()))
                .mobile(dto.getMobile())
                .email(dto.getEmail())
                .createTime(new Date())
                .status(true)
                .build();
        baseMapper.insert(addUser);

        return addUser;
    }

    // 2. 通过用户名获取用户
    @Override
    public User getUserByUsername(String username) {
        // 同上
        return baseMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername, username));
    }

    // 3. 用户登录
    @Override
    public String executeLogin(LoginDTO dto) {
        String token = null;
        try {
            User user = getUserByUsername(dto.getUsername());  // 获取输入用户名对应的用户对象
            String encodePwd = MD5Utils.getPwd(dto.getPassword());  // 将输入的密码MD5加密
            if(!encodePwd.equals(user.getPassword()))
            {
                throw new Exception("密码错误");
            }
            // 生成token
            token = JwtUtil.generateToken(String.valueOf(user.getUsername()));
        } catch (Exception e) {
            log.warn("用户不存在or密码验证失败=======>{}", dto.getUsername());
        }
        return token;
    }

    
}
