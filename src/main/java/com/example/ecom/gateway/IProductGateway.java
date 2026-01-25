package com.example.ecom.gateway;

import com.example.ecom.dto.ProductDTO;
import com.example.ecom.dto.ProductTitleDTO;

import java.io.IOException;
import java.util.List;


public interface IProductGateway {

    List<ProductTitleDTO> getProductCategory() throws IOException;

    ProductDTO getProductById(Long id) throws IOException;
}
