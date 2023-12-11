package com.turtle.book5.controller;

import com.turtle.book5.dto.OrderRequestDto;
import com.turtle.book5.dto.OrderResponseDto;
import com.turtle.book5.entity.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderController {

    @PostMapping("/order")
    public OrderResponseDto createOrder(@RequestBody OrderRequestDto requestDto){
        Order order = new Order(requestDto);

        OrderResponseDto OrderResponseDto = new OrderResponseDto(order);
        return OrderResponseDto;

    }

}
