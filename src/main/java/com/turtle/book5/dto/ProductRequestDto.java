package com.turtle.book5.dto;

import lombok.Getter;

@Getter
public class ProductRequestDto {
    //responseDto랑 하나 다른게 id 가 빠짐
    private int amount;
    public String name;
    public double price;



}
