package com.turtle.book5.controller;

import com.turtle.book5.dto.ProductRequestDto;
import com.turtle.book5.dto.ProductResponseDto;
import com.turtle.book5.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final Map<Long, Product> productList = new HashMap<>();

    @PostMapping("/products")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto requestDto)
    {


        Product product =  new Product(requestDto);


        Long maxId = productList.size() > 0 ? Collections.max(productList.keySet())+1 : 1;
        product.setId(maxId);

        productList.put(product.getId(), product);

        ProductResponseDto productResponseDto = new ProductResponseDto(product);


        return productResponseDto;
    }


    @GetMapping("/products")
    public List<ProductResponseDto> getProduct(){

        List<ProductResponseDto> responseList =  productList.values().stream()
                .map(ProductResponseDto::new).toList();

        return responseList;

    }


    @PutMapping("/products/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductRequestDto requestDto ){

        if(productList.containsKey(id)) {
            Product product = productList.get(id);


            product.update(requestDto);

            return product.getId();
        }
        else{
            throw new IllegalArgumentException("존재하는 상품이 아닙니다.");
        }
    }

    @DeleteMapping("/products/{id}")
    public Long deleteProduct(@PathVariable Long id){
        if(productList.containsKey(id)){
            productList.remove(id);
            return id;
        }
        else {
            throw new IllegalArgumentException("해당 상품이 존재하지 않습니다.");
        }
    }


}

