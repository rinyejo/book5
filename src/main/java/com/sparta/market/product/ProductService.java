package com.sparta.market.product;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("몰루"));
    }
    public Product addProduct(Product product) {
        System.out.println("Adding product: " + product);
        Product savedProduct = productRepository.save(product);
        System.out.println("Saved product: " + savedProduct);
        return savedProduct;
    }
    public Product updateProduct(Long productId, Product product) {
        getProductById(productId);
        product.setId(productId);
        return productRepository.save(product);
    }
    public void deleteProduct(Long productId) {
        getProductById(productId);
        productRepository.deleteById(productId);
    }
}
