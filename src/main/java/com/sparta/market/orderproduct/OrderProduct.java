package com.sparta.market.orderproduct;

import com.sparta.market.order.Order;
import com.sparta.market.product.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor


public class OrderProduct {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private Long quantity;

    @ManyToOne
    @JoinColumn(nullable = false, name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(nullable = false, name = "customer_order_id")
    private Order order;


}
