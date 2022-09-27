package com.hexiaofei.dubbo.customer.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hexiaofei.pubapi.entity.Order;
import com.hexiaofei.pubapi.entity.PageVo;
import com.hexiaofei.pubapi.entity.UserInfo;
import com.hexiaofei.pubapi.service.IOrderService;
import com.hexiaofei.pubapi.service.IUserService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author lcyj
 * @date 2022-04-16 11:24
 * @since
 */
@Component("orderService")
public class OrderServiceImpl implements IOrderService {

    @Reference
    private IUserService userService;

    @Override
    public int addObject(Order order) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserid("u-1001");
        userInfo.setUsername("张三");
        userService.addObject(userInfo);
        order.setOrderId(1001L);
        return 0;
    }

    @Override
    public List<Order> addBatchObject(List<Order> t) {
        return null;
    }


    @Override
    public int deleteObjectById(Integer id) {
        return 0;
    }

    @Override
    public int updateObjectById(Integer id) {
        return 0;
    }

    @Override
    public Order getObjectById(Integer id) {
        return null;
    }


    @Override
    public PageVo getListByPageVo(PageVo pageVo, Map paraMap) {
        return null;
    }
}
