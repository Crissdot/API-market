package com.course.market.persistence.repository;

import com.course.market.domain.PurchaseDomain;
import com.course.market.domain.repository.PurchaseRepositoryDomain;
import com.course.market.persistence.crud.PurchaseCrudRepository;
import com.course.market.persistence.entity.Purchase;
import com.course.market.persistence.mapper.PurchaseMapper;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepository implements PurchaseRepositoryDomain {
    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<PurchaseDomain> getAll() {
        List<Purchase> purchases = IterableUtils.toList(purchaseCrudRepository.findAll());
        return mapper.toPurchaseDomains(purchases);
    }

    @Override
    public Optional<List<PurchaseDomain>> getByClient(String clientId) {
        return purchaseCrudRepository.findByIdClient(clientId)
                .map(purchases -> mapper.toPurchaseDomains(purchases));
    }

    @Override
    public PurchaseDomain create(PurchaseDomain purchaseDomain) {
        Purchase purchase = mapper.toPurchaseEntity(purchaseDomain);
        purchase.getPurchaseProducts().forEach(product -> product.setPurchase(purchase));

        return mapper.toPurchaseDomain(purchaseCrudRepository.save(purchase));
    }
}
