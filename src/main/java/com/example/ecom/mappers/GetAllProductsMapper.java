package com.example.ecom.mappers;

import com.example.ecom.dto.FakeStoreProductResponseDTO;
import com.example.ecom.dto.ProductTitleDTO;

import java.util.List;

public class GetAllProductsMapper {

    public static FakeStoreProductResponseDTO toFakeStoreProductDTO(){
        return null;
    }

    public static List<ProductTitleDTO> toProductTitleDTO(List<FakeStoreProductResponseDTO> dto){
        return dto.stream()
                .map(product -> ProductTitleDTO.builder()
                        .title(product.getTitle())
                        .build()
                ).toList();

    }
}
