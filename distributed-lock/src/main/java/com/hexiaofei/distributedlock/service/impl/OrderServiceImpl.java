package com.hexiaofei.distributedlock.service.impl;

import com.hexiaofei.distributedlock.service.IOrderService;
import com.hexiaofei.distributedlock.utils.lock.IDistributedLock;
import com.hexiaofei.pubapi.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author lcyj
 * @date 2021-11-28 11:22
 * @since
 */
@Service
public class OrderServiceImpl implements IOrderService {

    /**
     * 自定义分布式锁
     */
    @Autowired
//    @Qualifier("redisDistributedLock")
    @Qualifier("redDistributedLock")
    private IDistributedLock redisDistributedLock;

    @Override
    public void addOrder(Order order) {

        redisDistributedLock.lock(order.getOrderId()+"");
        try{
            System.out.println(Thread.currentThread().getName()+":get lock-"+order.getOrderId());
            TimeUnit.SECONDS.sleep(60);
        }catch (Exception e){

        }finally {
            redisDistributedLock.unlock(order.getOrderId()+"");
            System.out.println(Thread.currentThread().getName()+":release lock-"+order.getOrderId());
        }

    }
}
