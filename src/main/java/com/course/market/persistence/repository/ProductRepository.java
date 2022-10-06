package com.course.market.persistence.repository;

import com.course.market.persistence.crud.ProductCrudRepository;
import com.course.market.persistence.entity.Product;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    @Autowired
    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll() {
        return IterableUtils.toList(productCrudRepository.findAll());
    }

    public List<Product> getByCategory (Integer idCategory) {
        return productCrudRepository.findByIdCategoryOrderByNameAsc(idCategory);
    }

    public Optional<List<Product>> getScarce (Integer quantity) {
        return productCrudRepository.findByStockLessThanAndStatus(quantity, true);
    }

    public Optional<Product> getProduct (Integer idProduct) {
        return productCrudRepository.findById(idProduct);
    }

    public Product createProduct (Product product) {
        return productCrudRepository.save(product);
    }

    public void deleteProduct (Integer idProduct) {
        productCrudRepository.deleteById(idProduct);
    }
}
