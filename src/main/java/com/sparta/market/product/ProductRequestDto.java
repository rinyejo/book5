package com.sparta.market.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDto {

    private String name;
    private Long price;
    private Long stock;

}

