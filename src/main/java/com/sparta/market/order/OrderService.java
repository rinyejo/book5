package com.sparta.market.order;

import com.sparta.market.orderproduct.OrderProduct;
import com.sparta.market.orderproduct.OrderProductDto;
import com.sparta.market.orderproduct.OrderProductRepository;
import com.sparta.market.product.Product;
import com.sparta.market.product.ProductService;
import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductService productService;
    private final OrderProductRepository orderProductRepository;

    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Order getOrderById(Long orderId) {

        return orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("주문 상품을 찾을 수 없습니다. ID: " + orderId));
    }

    public OrderDto getOrderDtoById(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("주문 상품을 찾을 수 없습니다. ID: " + orderId));

        return convertToDto(order);
    }

    public OrderDto createOrder(OrderDto orderDto) {
        Order order = new Order();
        // 주문 정보 설정
        order.setCustomerName(orderDto.getCustomerName());
        order.setCustomerPhone(orderDto.getCustomerPhone());

        // 주문 상품 정보 설정
        List<OrderProduct> orderProducts = new ArrayList<>();
        for (OrderProductDto orderProductDto : orderDto.getOrderProducts()) {
            Product product = productService.getProductById(orderProductDto.getProductId());
            OrderProduct orderProduct = new OrderProduct(order, product, orderProductDto.getQuantity());
            order.addOrderProduct(orderProduct);
            orderProducts.add(orderProduct);
        }

        // Order 엔티티에 주문 상품들을 설정
        order.setOrderProducts(orderProducts);

        // Order 총 가격 계산
        Long totalPrice = orderProducts.stream().mapToLong(OrderProduct::getPrice).sum();
        order.setTotalPrice(totalPrice);

        // Order 엔티티 저장
        Order savedOrder = orderRepository.save(order);

        // OrderProduct 저장
        for (OrderProduct orderProduct : orderProducts) {
            orderProduct.setOrder(savedOrder);
            orderProductRepository.save(orderProduct);
        }

        // 저장된 Order 엔티티 반환
        return convertToDto(savedOrder);
    }


    public OrderDto updateOrder(Long orderId, OrderDto orderDto) {
        Order existingOrder = getOrderById(orderId);

        // 업데이트할 주문 정보 설정
        existingOrder.setCustomerName(orderDto.getCustomerName());
        existingOrder.setCustomerPhone(orderDto.getCustomerPhone());

        // 업데이트할 주문 상품 정보 설정
        List<OrderProduct> updatedOrderProducts = new ArrayList<>();
        for (OrderProductDto orderProductDto : orderDto.getOrderProducts()) {
            Product product = productService.getProductById(orderProductDto.getProductId());
            OrderProduct orderProduct = new OrderProduct(existingOrder, product, orderProductDto.getQuantity());
            existingOrder.addOrderProduct(orderProduct);
            updatedOrderProducts.add(orderProduct);
        }

        // 기존의 주문 상품들 삭제
        existingOrder.getOrderProducts().clear();

        // 새로운 주문 상품들을 설정
        existingOrder.setOrderProducts(updatedOrderProducts);

        // 주문 총 가격 계산
        Long totalPrice = updatedOrderProducts.stream().mapToLong(OrderProduct::getPrice).sum();
        existingOrder.setTotalPrice(totalPrice);

        // 엔티티 저장
        Order updatedOrder = orderRepository.save(existingOrder);

        // 업데이트된 Order 엔티티를 DTO로 변환하여 반환
        return convertToDto(updatedOrder);
    }

    public void deleteOrder(Long orderId) {
        Order existingOrder = getOrderById(orderId);
        orderRepository.delete(existingOrder);
    }


    public Order updateOrderTotalPrice(Order order) {
        Long totalPrice = order.getOrderProducts().stream()
                .mapToLong(OrderProduct::getPrice)
                .sum();

        order.setTotalPrice(totalPrice);

        return orderRepository.save(order);
    }

    private OrderDto convertToDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setCustomerName(order.getCustomerName());
        orderDto.setCustomerPhone(order.getCustomerPhone());
        List<OrderProductDto> orderProductDtos = order.getOrderProducts().stream()
                .map(orderProduct -> {
                    OrderProductDto orderProductDto = new OrderProductDto();
                    orderProductDto.setProductId(orderProduct.getProduct().getId());
                    orderProductDto.setQuantity(orderProduct.getQuantity());
                    orderProductDto.setPrice(orderProduct.getPrice());

                    return orderProductDto;
                })
                .collect(Collectors.toList());

        orderDto.setOrderProducts(orderProductDtos);
        orderDto.setTotalPrice(order.getTotalPrice());
        return orderDto;
    }
}
