package com.sparta.market.orderproduct;

import com.sparta.market.order.Order;
import com.sparta.market.order.OrderService;
import com.sparta.market.product.Product;
import com.sparta.market.product.ProductService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class OrderProductService {

    private final OrderProductRepository orderProductRepository;
    private final ProductService productService;
    private final  OrderService orderService;

    @Transactional
    public List<OrderProductDto> getAllOrderProductDtos() {
        List<OrderProduct> orderProducts = orderProductRepository.findAll();
        return orderProducts.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public OrderProductDto getOrderProductDtoById(Long orderProductId) {
        OrderProduct orderProduct = orderProductRepository.findById(orderProductId)
                .orElseThrow(() -> new EntityNotFoundException("주문 상품을 찾을 수 없습니다. ID: " + orderProductId));

        return convertToDto(orderProduct);
    }

    @Transactional
    public OrderProductDto createOrderProduct(OrderProductDto orderProductDto) {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setQuantity(orderProductDto.getQuantity());

        Product product = productService.getProductById(orderProductDto.getProductId());
        Order order = orderService.getOrderById(orderProductDto.getOrderDtoId());

        orderProduct.setProduct(product);
        orderProduct.setOrder(order);

        orderProduct.calculatePrice();

        OrderProduct savedOrderProduct = orderProductRepository.save(orderProduct);
        return convertToDto(savedOrderProduct);
    }

    @Transactional
    public OrderProductDto updateOrderProduct(Long orderProductId, OrderProductDto orderProductDto) {
        OrderProduct existingOrderProduct = orderProductRepository.findById(orderProductId)
                .orElseThrow(() -> new EntityNotFoundException("주문 상품을 찾을 수 없습니다. ID: " + orderProductId));

        existingOrderProduct.setQuantity(orderProductDto.getQuantity());

        Product product = productService.getProductById(orderProductDto.getProductId());
        Order order = orderService.getOrderById(orderProductDto.getOrderDtoId());

        existingOrderProduct.setProduct(product);
        existingOrderProduct.setOrder(order);
        existingOrderProduct.calculatePrice();


        OrderProduct updatedOrderProduct = orderProductRepository.save(existingOrderProduct);
        orderService.updateOrderTotalPrice(order);
        return convertToDto(updatedOrderProduct);
    }


    @Transactional
    public void deleteOrderProduct(Long orderProductId) {
        OrderProduct existingOrderProduct = orderProductRepository.findById(orderProductId)
                .orElseThrow(() -> new EntityNotFoundException("삭제할 상품을 찾을 수 없습니다. id:" + orderProductId));
        orderProductRepository.delete(existingOrderProduct);
    }


    public OrderProductDto convertToDto(OrderProduct orderProduct) {
        OrderProductDto orderProductDto = new OrderProductDto();
        orderProductDto.setProductId(orderProduct.getProduct().getId());
        orderProductDto.setQuantity(orderProduct.getQuantity());
        orderProductDto.setOrderDtoId(orderProduct.getOrder().getId());
        orderProductDto.setPrice(orderProduct.getPrice());


        return orderProductDto;
    }
}