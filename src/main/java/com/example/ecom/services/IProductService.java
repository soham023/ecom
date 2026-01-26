package com.example.ecom.services;

import com.example.ecom.dto.ProductDTO;
import com.example.ecom.dto.ProductTitleDTO;
import com.example.ecom.dto.ProductWithCategoryDTO;

import java.io.IOException;
import java.util.List;

public interface IProductService {
    List<ProductTitleDTO> getAllProducts() throws IOException;

    ProductDTO getProductById(Long id) throws Exception;

    ProductDTO createProduct(ProductDTO dto) throws Exception;

    ProductWithCategoryDTO getProductWithCategory(Long id) throws Exception;
}
