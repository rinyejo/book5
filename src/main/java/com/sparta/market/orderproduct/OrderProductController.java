package com.sparta.market.orderproduct;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orderProducts")
@RequiredArgsConstructor
public class OrderProductController {


    private final OrderProductService orderProductService;

    @GetMapping
    public List<OrderProductDto> getAllOrderProducts() {
        return orderProductService.getAllOrderProductDtos();
    }

    @GetMapping("/{orderProductId}")
    public OrderProductDto getOrderProductById(@PathVariable Long orderProductId) {
        return orderProductService.getOrderProductDtoById(orderProductId);
    }

    @PostMapping
    public ResponseEntity<OrderProductDto> createOrderProduct(@RequestBody OrderProductDto orderProductDto) {
        OrderProductDto createdOrderProductDto = orderProductService.createOrderProduct(orderProductDto);
        return new ResponseEntity<>(createdOrderProductDto, HttpStatus.CREATED);
    }

    @PutMapping("/{orderProductId}")
    public ResponseEntity<OrderProductDto> updateOrderProduct(
            @PathVariable Long orderProductId,
            @RequestBody OrderProductDto orderProductDto) {
        OrderProductDto updatedOrderProductDto = orderProductService.updateOrderProduct(orderProductId, orderProductDto);
        return new ResponseEntity<>(updatedOrderProductDto, HttpStatus.OK);
    }

    @DeleteMapping("/{orderProductId}")
    public ResponseEntity<Void> deleteOrderProduct(@PathVariable Long orderProductId) {
        orderProductService.deleteOrderProduct(orderProductId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
