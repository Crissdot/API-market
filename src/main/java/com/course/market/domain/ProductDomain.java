package com.course.market.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDomain {
    private Integer productId;
    private String name;
    private Integer categoryId;
    private Double price;
    private Integer stock;
    private Boolean active;
    private CategoryDomain category;
}
