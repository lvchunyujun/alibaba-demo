package com.hexiaofei.pubapi.entity;

import java.math.BigDecimal;

/**
 * @author lcyj
 * @date 2021-11-28 11:30
 * @since
 */
public class Order {

    /**
     * 订单ID
     */
    private Long orderId;
    /**
     * 订单金额
     */
    private BigDecimal orderAmount;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 用户name
     */
    private String userName;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
