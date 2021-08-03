package com.example.milkorder_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.milkorder_backend.mapper.OrderMapper;
import com.example.milkorder_backend.mapper.TipMapper;
import com.example.milkorder_backend.model.dto.OneOrderDTO;
import com.example.milkorder_backend.model.dto.OrderDTO;
import com.example.milkorder_backend.model.entity.Drink;
import com.example.milkorder_backend.model.entity.Order;
import com.example.milkorder_backend.model.entity.Tip;
import com.example.milkorder_backend.model.entity.User;
import com.example.milkorder_backend.service.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.time.Year;
import java.util.*;

@Slf4j  // 日志
@Service  // 标记当前类是一个service类，加上该注解会将当前类自动注入到spring容器中，不需要再在applicationContext.xml文件定义bean了
@Transactional(rollbackFor = Exception.class)
public class IOrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Resource
    private IUserService iUserService;
    @Resource
    private IDrinkService iDrinkService;
    @Resource
    private ITipService iTipService;


    // 1. 发起订单
    @Override
    public Map<String,?> executeAddOrder(OrderDTO dto, String username) {

        List<OneOrderDTO> list = dto.getProducts();
        List<Order> orderList = new ArrayList<>();
        Map map = new HashMap<>();
        int counter = 1;
        for (OneOrderDTO oneOrderDTO : list) {
            Double cost = 0.0 ;

            Drink drink = iDrinkService.getDrinkByName(oneOrderDTO.getDrinkName());
            if (ObjectUtils.isEmpty(drink)){
                return null;
            }
            // 计算奶茶价格
            cost += Double.parseDouble(drink.getPrice());
            // 计算所有小料总价格
            String tipDes = oneOrderDTO.getTipDes();
            for (int i = -1 ; i < tipDes.length() ; i = tipDes.indexOf("&",i) + 1){
                if (i == 0 )
                    break;
                else if (i == -1)
                    i++;
                if (tipDes.indexOf("&",i) != -1)
                    cost += Double.parseDouble(iTipService.getTipPrice(tipDes.substring(i,tipDes.indexOf("&",i)))) ;
                else
                    cost += Double.parseDouble(iTipService.getTipPrice(tipDes.substring(i,tipDes.length())));
            }

            // 插入表单
            Order addOrder = Order.builder()
                    .delId(dto.getDelId())
                    .username(username)
                    .store(dto.getStore())
                    .createTime(new Date())
                    .isTakeOut(dto.isTakeOut())
                    .drinkName(oneOrderDTO.getDrinkName())
                    .drinkNum(oneOrderDTO.getDrinkNum())
                    .price(String.valueOf(cost*oneOrderDTO.getDrinkNum()))
                    .tipDes(oneOrderDTO.getTipDes())
                    .otherDes(oneOrderDTO.getOtherDes())
                    .build();
            baseMapper.insert(addOrder) ;
            orderList.add(addOrder);
        }
        map.put("order",orderList);

        // 计算排队时间
        List<Order> noFinisedOrder = baseMapper.getAllFinishedOrder();
        if (ObjectUtils.isEmpty(noFinisedOrder)){
            map.put("numOfLine",0);
        }
        else
            map.put("numOfLine",noFinisedOrder.size());

        return map;
    }

    @Override
    public List<Order> orderListOfUser(String username) {
        return baseMapper.getOrderListOfUser(username);
    }
}
