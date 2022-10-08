package com.course.market.persistence.mapper;

import com.course.market.domain.ProductDomain;
import com.course.market.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProduct", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "salePrice", target = "price"),
            @Mapping(source = "stock", target = "stock"),
            @Mapping(source = "status", target = "active"),
            @Mapping(source = "category", target = "category"),
    })
    ProductDomain toProductDomain(Product product);
    List<ProductDomain> toProductsDomain(List<Product> products);

    @InheritInverseConfiguration
    @Mapping(target = "barCode", ignore = true)
    Product toProductPersistence(ProductDomain productDomain);
}
