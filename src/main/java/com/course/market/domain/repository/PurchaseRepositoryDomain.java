package com.course.market.domain.repository;

import com.course.market.domain.PurchaseDomain;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepositoryDomain {
    List<PurchaseDomain> getAll();
    Optional<List<PurchaseDomain>> getByClient(String clientId);
    PurchaseDomain create(PurchaseDomain purchase);
}
