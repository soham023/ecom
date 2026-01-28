package com.example.ecom.services;

import com.example.ecom.dto.ProductDTO;
import com.example.ecom.dto.ProductTitleDTO;
import com.example.ecom.dto.ProductWithCategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBProductService implements IProductService {
    @Override
    public List<ProductTitleDTO> getAllProducts() {
        return List.of();
    }

    @Override
    public ProductDTO getProductById(Long id) throws Exception {
        return null;
    }

    @Override
    public ProductDTO createProduct(ProductDTO dto) throws Exception {
        return null;
    }

    @Override
    public ProductWithCategoryDTO getProductWithCategory(Long id) {
        return null;
    }
}
