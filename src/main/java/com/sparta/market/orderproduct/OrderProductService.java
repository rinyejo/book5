package com.sparta.market.orderproduct;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProductService {
    @Autowired
    private OrderProductRepository orderProductRepository;

    public List<OrderProduct> getAllOrderProducts() {
        return orderProductRepository.findAll();
    }

    public OrderProduct getOrderProductById(Long orderProductId) {
        return orderProductRepository.findById(orderProductId)
                .orElseThrow(() -> new EntityNotFoundException("주문 상품을 찾을 수 없습니다. ID: " + orderProductId));
    }

    public OrderProduct createOrderProduct(OrderProductRequestDto orderProductRequestDto) {
        OrderProduct orderProduct = new OrderProduct();
        // 주문 상품 생성에 필요한 비즈니스 로직 구현
        return orderProductRepository.save(orderProduct);
    }

    public OrderProduct updateOrderProduct(Long orderProductId, OrderProductRequestDto orderProductRequestDto) {
        OrderProduct existingOrderProduct = getOrderProductById(orderProductId);
        // 주문 상품 요청 DTO를 기반으로 주문 상품 속성 업데이트
        return orderProductRepository.save(existingOrderProduct);
    }

    public void deleteOrderProduct(Long orderProductId) {
        OrderProduct existingOrderProduct = getOrderProductById(orderProductId);
        orderProductRepository.delete(existingOrderProduct);
    }
}

