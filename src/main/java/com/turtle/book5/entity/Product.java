package com.turtle.book5.entity;

import com.turtle.book5.dto.ProductRequestDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private long id;
    private int amount;
    public String name;
    public double price;
    public Product(ProductRequestDto requestDto) { //클라이언트로부터 받아온 데이터가 requestDto에 들어가있음.
        //이걸 사용해서 필드 부분의 데이터를 넣어줄것임
        //이게 requestDto를 entity로 바꿔주는 것
        this.name = requestDto.getName();
        this.amount = requestDto.getAmount();
        this.price = requestDto.getPrice();




    }

    public void update(ProductRequestDto requestDto)  { //update 부분을 위해 만들어진것

        this.name = requestDto.getName();
        this.amount = requestDto.getAmount();
        this.price = requestDto.getPrice();


    }
}
