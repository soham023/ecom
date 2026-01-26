package com.example.ecom.mappers;

import com.example.ecom.dto.ProductDTO;
import com.example.ecom.dto.ProductWithCategoryDTO;
import com.example.ecom.entities.CategoryEntity;
import com.example.ecom.entities.ProductEntity;

public class ProductMapper {

    public static ProductDTO toDTOFromEntity(ProductEntity productEntity){
        return ProductDTO.builder()
                .id(productEntity.getId())
                .price(productEntity.getPrice())
                .title(productEntity.getTitle())
                .image(productEntity.getImage())
                .categoryId(productEntity.getCategory().getId())
                .description(productEntity.getDescription())
                .build();
    }

    public static ProductEntity toEntityFromDTO(ProductDTO productDTO, CategoryEntity category){
        return ProductEntity.builder()
                .price(productDTO.getPrice())
                .title(productDTO.getTitle())
                .image(productDTO.getImage())
                .category(category)
                .description(productDTO.getDescription())
                .build();
    }

    public static ProductWithCategoryDTO toProductWithCategoryDTO(ProductEntity productEntity) {
        return ProductWithCategoryDTO.builder()
                .id(productEntity.getId())
                .price(productEntity.getPrice())
                .title(productEntity.getTitle())
                .image(productEntity.getImage())
//                productEntity.getCategory() is actually a DB cal in case of Lazy Loading(FETCHTYPE.LAZY)
                .category(CategoryMapper.toDTOFromEntity(productEntity.getCategory()))
                .description(productEntity.getDescription())
                .build();
    }
}
