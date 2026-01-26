package com.example.ecom.services;

import com.example.ecom.dto.ProductDTO;
import com.example.ecom.dto.ProductTitleDTO;
import com.example.ecom.dto.ProductWithCategoryDTO;
import com.example.ecom.gateway.IProductGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service("fakeStoreProductService")

// the moment we implement our Inteface we are bound to implement all the methods of that interface
public class FakeStoreProductService implements IProductService {


    private  final IProductGateway productGateway;

    public FakeStoreProductService(IProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public List<ProductTitleDTO> getAllProducts() throws IOException {
        return this.productGateway.getProductCategory();
    }

    @Override
    public ProductDTO getProductById(Long id) throws Exception{
        return this.productGateway.getProductById(id);
    }

    @Override
    public ProductDTO createProduct(ProductDTO dto) throws Exception {
        return null;
    }

    @Override
    public ProductWithCategoryDTO getProductWithCategory(long id) {
        return null;
    }
}
