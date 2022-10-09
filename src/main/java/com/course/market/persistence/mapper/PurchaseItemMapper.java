package com.course.market.persistence.mapper;

import com.course.market.domain.PurchaseItemDomain;
import com.course.market.persistence.entity.PurchaseProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idProduct", target = "productId"),
            @Mapping(source = "quantity", target = "quantity"),
            @Mapping(source = "total", target = "total"),
            @Mapping(source = "status", target = "active")
    })
    PurchaseItemDomain toPurchaseItemDomain (PurchaseProduct purchaseProduct);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "purchase", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "id.idPurchase", ignore = true),
    })
    PurchaseProduct toPurchaseProduct (PurchaseItemDomain purchaseItemDomain);
}
