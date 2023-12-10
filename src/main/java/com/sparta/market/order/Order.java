package com.sparta.market.order;

import com.sparta.market.orderproduct.OrderProduct;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "customer_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private String customerName;
    @Column(nullable = false)
    private String customerPhone;
    @Column(nullable = false)
    private Long totalPrice;
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderProduct> orderProducts;


}
