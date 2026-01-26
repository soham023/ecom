package com.example.ecom.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductWithCategoryDTO {
    private String image;
    private Double price;
    private String description;
    private Long id;
    private String title;
    private CategoryDTO category;
}
