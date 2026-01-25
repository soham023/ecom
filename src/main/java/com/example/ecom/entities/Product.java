package com.example.ecom.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "product")
public class Product extends BaseEntity{
    private String image;
    private Double price;
    private String description;
    private String title;
    private String category;
}
