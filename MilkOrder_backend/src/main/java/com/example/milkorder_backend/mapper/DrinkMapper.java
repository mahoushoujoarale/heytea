package com.example.milkorder_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.milkorder_backend.model.entity.Drink;
import org.springframework.stereotype.Repository;

/**
 * 奶茶
 */

@Repository
public interface DrinkMapper extends BaseMapper<Drink> {
    Drink getDrinkByName(String name) ;
}
