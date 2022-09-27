package com.hexiaofei.distributedlock.web;

import com.hexiaofei.distributedlock.service.IOrderService;
import com.hexiaofei.pubapi.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author lcyj
 * @date 2021-11-28 11:20
 * @since
 */
@RestController
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @RequestMapping(value="/addOrder/{orderId}")
    public String addOrder(@PathVariable("orderId") Long orderId){

        Order order = new Order();
        order.setOrderId(orderId);
        order.setUserId(100);
        order.setOrderAmount(new BigDecimal("100000"));
        orderService.addOrder(order);
        return null;
    }
}
