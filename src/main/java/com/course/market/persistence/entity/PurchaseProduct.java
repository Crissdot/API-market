package com.course.market.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "compras_productos")
public class PurchaseProduct {
    @EmbeddedId
    private PurchaseProductPK id;

    @Column(name = "cantidad")
    private Integer quantity;

    private Double total;

    @Column(name = "estado")
    private Boolean status;

    @ManyToOne
    @MapsId("idPurchase")
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Product product;
}
