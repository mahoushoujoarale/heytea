package com.example.milkorder_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.milkorder_backend.model.dto.DrinkAddDTO;
import com.example.milkorder_backend.model.dto.LoginDTO;
import com.example.milkorder_backend.model.dto.RegisterDTO;
import com.example.milkorder_backend.model.entity.Drink;
import com.example.milkorder_backend.model.entity.User;

public interface IDrinkService extends IService<Drink> {
    /**
     * 新增奶茶，只有管理员才有权限
     *
     * @param dto
     * @return 注册对象
     */
    Drink executeAdd(DrinkAddDTO dto);
    /**
     * 通过奶茶名获取奶茶信息
     *
     * @param name
     * @return dbUser
     */
 //   User getUserByUsername(String name);
}
