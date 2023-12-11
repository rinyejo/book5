package com.turtle.book5.entity;

import com.turtle.book5.dto.OrderRequestDto;

public class Order {

    private long order_id;
    private String ctm_name;
    private String ctm_phone;
    private int total_price;

    public Order(OrderRequestDto requestDto) {

    }
}
