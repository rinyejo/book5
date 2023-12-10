package com.sparta.market.order;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("주문을 찾을 수 없습니다. ID: " + orderId));
    }

    public Order createOrder(OrderRequestDto orderRequestDto) {
        Order order = new Order();

        return orderRepository.save(order);
    }

    public Order updateOrder(Long orderId, OrderRequestDto orderRequestDto) {
        Order existingOrder = getOrderById(orderId);

        return orderRepository.save(existingOrder);
    }

    public void deleteOrder(Long orderId) {
        Order existingOrder = getOrderById(orderId);
        orderRepository.delete(existingOrder);
    }
}
