package com.sparta.market.orderproduct;

import java.util.List;
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
public class OrderProductController {

    private OrderProductService orderProductService;

    @GetMapping
    public List<OrderProduct> getAllOrderProducts() {
        return orderProductService.getAllOrderProducts();
    }
    @GetMapping("/{orderProductId}")
    public OrderProduct getOrderProductById(@PathVariable Long orderProductId) {
        return orderProductService.getOrderProductById(orderProductId);
    }
    @PostMapping
    public ResponseEntity<OrderProduct> createOrderProduct(@RequestBody OrderProductRequestDto orderProductRequestDto) {
        OrderProduct createdOrderProduct = orderProductService.createOrderProduct(orderProductRequestDto);
        return new ResponseEntity<>(createdOrderProduct, HttpStatus.CREATED);
    }
    @PutMapping("/{orderProductId}")
    public ResponseEntity<OrderProduct> updateOrderProduct(@PathVariable Long orderProductId, @RequestBody OrderProductRequestDto orderProductRequestDto) {
        OrderProduct updatedOrderProduct = orderProductService.updateOrderProduct(orderProductId, orderProductRequestDto);
        return new ResponseEntity<>(updatedOrderProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{orderProductId}")
    public ResponseEntity<Void> deleteOrderProduct(@PathVariable Long orderProductId) {
        orderProductService.deleteOrderProduct(orderProductId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
