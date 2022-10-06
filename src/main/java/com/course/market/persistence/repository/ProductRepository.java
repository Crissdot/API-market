package com.course.market.persistence.repository;

import com.course.market.persistence.crud.ProductCrudRepository;
import com.course.market.persistence.entity.Product;
import org.apache.commons.collections4.IterableUtils;

import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll() {
        return IterableUtils.toList(productCrudRepository.findAll());
    }

    public List<Product> getByCategory (Integer idCategory) {
        return productCrudRepository.findByIdCategoryOrderByNameAsc(idCategory);
    }

    public Optional<List<Product>> getScarce (Integer quantity) {
        return productCrudRepository.findByStockLessThanAndState(quantity, true);
    }
}
