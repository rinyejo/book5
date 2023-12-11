package com.sparta.market.order;

import com.sparta.market.orderproduct.OrderProductDto;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {
    private Long id;
    private String customerName;
    private String customerPhone;
    private List<OrderProductDto> orderProducts;
    private Long totalPrice;

}

