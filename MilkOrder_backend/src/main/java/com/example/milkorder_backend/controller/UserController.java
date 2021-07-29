package com.example.milkorder_backend.controller;

import com.example.milkorder_backend.common.api.ApiResult;
import com.example.milkorder_backend.jwt.JwtUtil;
import com.example.milkorder_backend.model.dto.LoginDTO;
import com.example.milkorder_backend.model.dto.RegisterDTO;
import com.example.milkorder_backend.model.entity.User;
import com.example.milkorder_backend.service.IUserService;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService iUserService;

    /**
     * 注册
     * @param dto
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ApiResult<Map<String, Object>> register(@Valid @RequestBody RegisterDTO dto) {
        User user = iUserService.executeRegister(dto);
        if (ObjectUtils.isEmpty(user)) {
            return ApiResult.failed("账号注册失败,号码已存在");
        }
        Map<String, Object> map = new HashMap<>(16);
        map.put("user", user);
        return ApiResult.success(map,"注册成功");
    }

    /**
     * 登录
     * @param dto
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ApiResult<Map<String, String>> login(@Valid @RequestBody LoginDTO dto) {
        String token = iUserService.executeLogin(dto);
        if (ObjectUtils.isEmpty(token)) {
            return ApiResult.failed("账号密码错误");
        }
        Map<String, String> map = new HashMap<>(16);
        map.put("token", token);
        return ApiResult.success(map, "登录成功");
    }

    /**
     * 改密
     * @param dto
     * @return
     */
    @RequestMapping(value = "/forget", method = RequestMethod.POST)
    public ApiResult<Map<String, String>> changePass(@Valid @RequestBody LoginDTO dto) {
        String token = iUserService.changePassword(dto);
        Map<String, String> map = new HashMap<>(16);
        if (token == "该号码未注册") {
            return ApiResult.failed(token);
        }
            return ApiResult.success(map,token);
    }

    /**
     * 从token里面获取用户名，在通过用户名获取用户信息
     * @param userName
     * @return
     */
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ApiResult<User> getUserByToken(@RequestHeader(value = JwtUtil.USER_NAME) String userName) {
        User user = iUserService.getUserByUsername(userName);
        return ApiResult.success(user);
    }

    /**
     * 通过用户名获取用户信息
     * @param userName
     * @return
     */
    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    public ApiResult<User> getUser(@RequestParam("username") String userName) {
        User user = iUserService.getUserByUsername(userName);
        if (ObjectUtils.isEmpty(user)){
            return ApiResult.failed("该用户不存在");
        }
        return ApiResult.success(user);
    }
}
