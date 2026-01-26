package com.example.ecom.mappers;

import com.example.ecom.dto.CategoryDTO;
import com.example.ecom.dto.ProductDTO;
import com.example.ecom.entities.CategoryEntity;
import com.example.ecom.entities.ProductEntity;

public class CategoryMapper {
    public static CategoryDTO toDTOFromEntity(CategoryEntity categoryEntity){
        return CategoryDTO.builder()
                .name(categoryEntity.getName())
                .Id(categoryEntity.getId())
                .products(categoryEntity.getProducts())
                .build();
    }

    public static CategoryEntity toEntityFromDTO(CategoryDTO categoryDTO){
        return CategoryEntity.builder()
                .name(categoryDTO.getName())
                .products(categoryDTO.getProducts())
                .build();
    }
}
