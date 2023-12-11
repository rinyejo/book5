package com.turtle.book5.dto;

import com.turtle.book5.entity.Product;
import lombok.Getter;

@Getter
public class ProductResponseDto {
    //Product 클래스와 유사하다. 똑같다. 근데 똑같은 기능을 하는 건 아님. 이 클래스는 데이터 전송 및 이동을 위해 생성되는 객체임.
    private long id;
    private int amount;
    public String name;
    public double price;

    public ProductResponseDto(Product product) {

        this.id = product.getId();
        this.amount = product.getAmount();
        this.name = product.getName();
        this.price = product.getPrice();


    }
}
