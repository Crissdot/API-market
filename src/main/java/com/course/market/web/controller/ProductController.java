package com.course.market.web.controller;

import com.course.market.domain.ProductDomain;
import com.course.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDomain> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{productId}")
    public Optional<ProductDomain> getProduct(@PathVariable Integer productId) {
        return productService.getProduct(productId);
    }

    @GetMapping("/category/{categoryId}")
    public Optional<List<ProductDomain>> getByCategory(@PathVariable Integer categoryId) {
        return productService.getByCategory(categoryId);
    }

    @PostMapping
    public ProductDomain create(@RequestBody ProductDomain productDomain) {
        return productService.create(productDomain);
    }

    @DeleteMapping("/{productId}")
    public Boolean delete(@PathVariable Integer productId) {
        return productService.getProduct(productId).map(productDomain -> {
            productService.delete(productId);
            return true;
        }).orElse(false);
    }
}
