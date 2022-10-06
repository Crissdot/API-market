package com.course.market.persistence.repository;

import com.course.market.persistence.crud.ProductCrudRepository;
import com.course.market.persistence.entity.Product;
import org.apache.commons.collections4.IterableUtils;

import java.util.List;

public class ProductRepository {
    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll() {
        return IterableUtils.toList(productCrudRepository.findAll());
    }
}
