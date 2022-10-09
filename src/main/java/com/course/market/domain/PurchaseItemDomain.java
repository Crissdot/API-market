package com.course.market.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseItemDomain {
    private int productId;
    private int quantity;
    private double total;
    private boolean active;
}
