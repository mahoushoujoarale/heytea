package com.example.milkorder_backend.controller;

import com.example.milkorder_backend.common.api.ApiResult;
import com.example.milkorder_backend.jwt.JwtUtil;
import com.example.milkorder_backend.model.dto.DrinkAddDTO;
import com.example.milkorder_backend.model.dto.RegisterDTO;
import com.example.milkorder_backend.model.entity.Drink;
import com.example.milkorder_backend.model.entity.User;
import com.example.milkorder_backend.service.IDrinkService;
import com.example.milkorder_backend.service.IUserService;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/drink")
public class DrinkController {
    @Resource
    private IDrinkService iDrinkService;
    @Resource
    private IUserService iUserService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResult<Map<String, Object>> Add(@Valid @RequestBody DrinkAddDTO dto, @RequestHeader(value = JwtUtil.USER_NAME) String userName) {
        /**
         * 先看登录用户是否有权限
         */
        System.out.println(userName);
        User user = iUserService.getUserByUsername(userName);
        if (user.getRoleId() != 2){
            return ApiResult.failed("用户无权限");
        }

        Drink drink = iDrinkService.executeAdd(dto);
        if (ObjectUtils.isEmpty(drink)) {
            return ApiResult.failed("奶茶新增失败,已存在");
        }
        Map<String, Object> map = new HashMap<>(16);
        map.put("drink", drink);
        return ApiResult.success(map);
    }
}
