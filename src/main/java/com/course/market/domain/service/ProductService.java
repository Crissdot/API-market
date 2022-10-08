package com.course.market.domain.service;

import com.course.market.domain.ProductDomain;
import com.course.market.domain.repository.ProductRepositoryDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepositoryDomain productRepositoryDomain;

    public List<ProductDomain> getAll() {
        return productRepositoryDomain.getAll();
    }

    public Optional<ProductDomain> getProduct(Integer productId) {
        return productRepositoryDomain.getProduct(productId);
    }

    public Optional<List<ProductDomain>> getByCategory(Integer categoryId) {
        return productRepositoryDomain.getByCategory(categoryId);
    }

    public ProductDomain create(ProductDomain productDomain) {
        return productRepositoryDomain.create(productDomain);
    }

    public Boolean delete(Integer productId) {
        return getProduct(productId).map(productDomain -> {
            productRepositoryDomain.delete(productId);
            return true;
        }).orElse(false);
    }
}
