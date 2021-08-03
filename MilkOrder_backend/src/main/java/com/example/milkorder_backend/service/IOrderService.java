package com.example.milkorder_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.milkorder_backend.model.dto.OrderDTO;
import com.example.milkorder_backend.model.entity.Order;

import java.util.List;
import java.util.Map;

public interface IOrderService extends IService<Order> {
    /**
     * 发起订单
     * @param dto
     * @param username
     * @return
     */
    Map executeAddOrder(OrderDTO dto, String username) ;

    List<Order> orderListOfUser(String username) ;
}
