package com.example.milkorder_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.milkorder_backend.mapper.OrderMapper;
import com.example.milkorder_backend.mapper.TipMapper;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j  // 日志
@Service  // 标记当前类是一个service类，加上该注解会将当前类自动注入到spring容器中，不需要再在applicationContext.xml文件定义bean了
@Transactional(rollbackFor = Exception.class)
public class IOrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Resource
    private IClaService iClaService;
    @Resource
    private IUserService iUserService;
    @Resource
    private IDrinkService iDrinkService;
    @Resource
    private ITipService iTipService;


    // 1. 发起订单
    @Test
    @Override
    public Map executeAddOrder(OrderDTO dto, String username) {
        Double cost = 0.0 ;
        Drink drink = iDrinkService.getDrinkByName(dto.getDrinkName());
        if (ObjectUtils.isEmpty(drink)){
            return null;
        }
        // 计算奶茶价格
        cost += Double.parseDouble(drink.getPrice());
        String tipDes = dto.getTipDes();
        // 计算所有小料总价格
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
        //  下单者信息
        User user = iUserService.getUserByUsername(username);
        String mobile = user.getMobile();
        if (!ObjectUtils.isEmpty(dto.getMobile()))
            mobile = dto.getMobile();
        // 插入表单
        Order addOrder = Order.builder()
                .sAddress(dto.getAddress())
                .username(user.getUsername())
                .mobile(mobile)
                .drinkName(dto.getDrinkName())
                .tipDes(dto.getTipDes())
                .otherDes(dto.getOtherDes())
                .price(String.valueOf(cost))
                .isFinish(false)
                .createTime(new Date())
                .build() ;
        baseMapper.insert(addOrder) ;
        Map map = new HashMap<>();
        map.put("order",addOrder);

        List<Order> list = baseMapper.getAllFinishedOrder();
        map.put("numOfLine",list.size());

        return map;
    }

    @Override
    public List<Order> orderListOfUser(String username) {
        return baseMapper.getOrderListOfUser(username);
    }
}
