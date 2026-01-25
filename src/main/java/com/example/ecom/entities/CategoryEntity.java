package com.example.ecom.entities;

import jakarta.persistence.*;

import java.util.List;

public class CategoryEntity extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String name;

// 1 category can have multiple products associated with it
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductEntity> products;
}
