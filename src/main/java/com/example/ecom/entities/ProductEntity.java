package com.example.ecom.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "product")
public class ProductEntity extends BaseEntity{
    private String image;
    private Double price;
    private String description;
    private String title;

    @ManyToOne
//    Multiple products can be associated to single category
    @JoinColumn(name = "categoryId", nullable = false)
    private CategoryEntity category;
}
