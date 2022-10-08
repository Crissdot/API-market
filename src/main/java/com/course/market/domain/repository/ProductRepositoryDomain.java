package com.course.market.domain.repository;

import com.course.market.domain.ProductDomain;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryDomain {
    List<ProductDomain> getAll();
    Optional<List<ProductDomain>> getByCategory(Integer categoryId);
    Optional<List<ProductDomain>> getScarceProducts(Integer quantity);
    Optional<ProductDomain> getProduct(Integer productId);
    ProductDomain create(ProductDomain product);
    void delete(Integer productId);
}
