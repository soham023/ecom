package com.example.ecom.mappers;

import com.example.ecom.dto.ProductDTO;
import com.example.ecom.entities.ProductEntity;

public class ProductMapper {

    public static ProductDTO toDTOFromEntity(ProductEntity productEntity){
        return ProductDTO.builder()
                .id(productEntity.getId())
                .price(productEntity.getPrice())
                .title(productEntity.getTitle())
                .image(productEntity.getImage())
                .category(productEntity.getCategory())
                .description(productEntity.getDescription())
                .build();
    }

    public static ProductEntity toEntityFromDTO(ProductDTO productDTO){
        return ProductEntity.builder()
                .price(productDTO.getPrice())
                .title(productDTO.getTitle())
                .image(productDTO.getImage())
                .category(productDTO.getCategory())
                .description(productDTO.getDescription())
                .build();
    }
}
