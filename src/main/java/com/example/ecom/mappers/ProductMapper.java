package com.example.ecom.mappers;

import com.example.ecom.dto.ProductDTO;
import com.example.ecom.entities.Product;

public class ProductMapper {

    public static ProductDTO toDTOFromEntity(Product product){
        return ProductDTO.builder()
                .id(product.getId())
                .price(product.getPrice())
                .title(product.getTitle())
                .image(product.getImage())
                .category(product.getCategory())
                .description(product.getDescription())
                .build();
    }

    public static Product toEntityFromDTO(ProductDTO productDTO){
        return Product.builder()
                .price(productDTO.getPrice())
                .title(productDTO.getTitle())
                .image(productDTO.getImage())
                .category(productDTO.getCategory())
                .description(productDTO.getDescription())
                .build();
    }
}
