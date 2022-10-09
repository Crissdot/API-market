package com.course.market.persistence.mapper;

import com.course.market.domain.PurchaseDomain;
import com.course.market.persistence.entity.Purchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "idPurchase", target = "purchaseId"),
            @Mapping(source = "idClient", target = "clientId"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "paymentMethod", target = "paymentMethod"),
            @Mapping(source = "comment", target = "comment"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "purchaseProducts", target = "items")
    })
    PurchaseDomain toPurchaseDomain(Purchase purchase);
    List<PurchaseDomain> toPurchaseDomains(List<Purchase> purchases);

    @InheritInverseConfiguration
    @Mapping(target = "client", ignore = true)
    Purchase toPurchaseEntity(PurchaseDomain purchaseDomain);
}
