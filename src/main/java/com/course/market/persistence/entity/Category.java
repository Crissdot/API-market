package com.course.market.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategory;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "estado")
    private Boolean state;
}