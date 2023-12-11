package com.sparta.market.orderproduct;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderProductDto {
    private Long quantity;
    private Long productId;
    private Long orderDtoId;
    private Long price;
}
