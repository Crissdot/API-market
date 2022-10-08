package com.course.market.domain.repository;

import com.course.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(Integer categoryId);
    Optional<List<Product>> getScarceProducts(Integer quantity);
    Optional<Product> getProduct(Integer productId);
    Product create(Product product);
    void delete(Integer productId);
}
