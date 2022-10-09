package com.course.market.domain.service;

import com.course.market.domain.PurchaseDomain;
import com.course.market.domain.repository.PurchaseRepositoryDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepositoryDomain purchaseRepositoryDomain;

    public List<PurchaseDomain> getAll() {
        return purchaseRepositoryDomain.getAll();
    }

    public Optional<List<PurchaseDomain>> getByClient(String clientId) {
        return purchaseRepositoryDomain.getByClient(clientId);
    }

    public PurchaseDomain create(PurchaseDomain purchase) {
        return purchaseRepositoryDomain.create(purchase);
    }
}
