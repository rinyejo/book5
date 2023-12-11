package com.turtle.book5.dto;

import com.turtle.book5.entity.Order;
import lombok.Getter;

@Getter
public class OrderResponseDto {

    private long order_id;
    private String ctm_name;
    private String ctm_phone;
    private int total_price;



    public OrderResponseDto(Order order) {
    }
}
