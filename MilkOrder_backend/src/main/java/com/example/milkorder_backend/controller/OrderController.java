package com.example.milkorder_backend.controller;

import com.example.milkorder_backend.common.api.ApiResult;
import com.example.milkorder_backend.jwt.JwtUtil;
import com.example.milkorder_backend.model.dto.DrinkAddDTO;
import com.example.milkorder_backend.model.dto.OrderDTO;
import com.example.milkorder_backend.model.entity.Drink;
import com.example.milkorder_backend.model.entity.Order;
import com.example.milkorder_backend.model.entity.User;
import com.example.milkorder_backend.service.IOrderService;
import com.example.milkorder_backend.service.IUserService;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private IOrderService iOrderService;
    @Resource
    private IUserService iUserService;
    /**
     * 发起订单
     * @param dto
     * @param userName
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResult<Map<String, Object>> orderAdd(@Valid @RequestBody OrderDTO dto, @RequestHeader(value = JwtUtil.USER_NAME) String userName) {
        Map map = iOrderService.executeAddOrder(dto, userName);
        Map<String, Object> resMap = new HashMap<>(16);
        if (ObjectUtils.isEmpty(map))
            return ApiResult.failed("下单失败");
        resMap.put("waitTime",map.get("numOfLine")) ;
        resMap.put("code",map.get("code")) ;
        resMap.put("order",map.get("order")) ;
        return ApiResult.success(resMap,"下单成功");
    }

    /**
     * 获取当前用户全部历史订单
     * @param userName
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ApiResult<List<Order>> getOrderListOfUser(@RequestHeader(value = JwtUtil.USER_NAME) String userName) {
        List<Order> list = iOrderService.orderListOfUser(userName);
        return ApiResult.success(list);
    }
}
