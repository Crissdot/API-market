package com.course.market.persistence.repository;

import com.course.market.domain.ProductDomain;
import com.course.market.domain.repository.ProductRepositoryDomain;
import com.course.market.persistence.crud.ProductCrudRepository;
import com.course.market.persistence.entity.Product;
import com.course.market.persistence.mapper.ProductMapper;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements ProductRepositoryDomain {
    @Autowired
    private ProductCrudRepository productCrudRepository;
    private ProductMapper mapper;

    @Override
    public List<ProductDomain> getAll() {
        List<Product> products = IterableUtils.toList(productCrudRepository.findAll());
        return mapper.toProductsDomain(products);
    }

    @Override
    public Optional<List<ProductDomain>> getByCategory (Integer idCategory) {
        List<Product> products = productCrudRepository.findByIdCategoryOrderByNameAsc(idCategory);
        return Optional.of(mapper.toProductsDomain(products));
    }

    @Override
    public Optional<List<ProductDomain>> getScarceProducts(Integer quantity) {
        Optional<List<Product>> products = productCrudRepository.findByStockLessThanAndStatus(quantity, true);
        return products.map(prods -> mapper.toProductsDomain(prods));
    }

    @Override
    public Optional<ProductDomain> getProduct (Integer idProduct) {
        return productCrudRepository.findById(idProduct).map(productDomain -> mapper.toProductDomain(productDomain));
    }

    @Override
    public ProductDomain create(ProductDomain productDomain) {
        Product product = mapper.toProductPersistence(productDomain);
        return mapper.toProductDomain(productCrudRepository.save(product));
    }

    @Override
    public void delete(Integer productId) {
        productCrudRepository.deleteById(productId);
    }
}
