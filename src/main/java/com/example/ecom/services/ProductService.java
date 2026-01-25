package com.example.ecom.services;

import com.example.ecom.dto.ProductDTO;
import com.example.ecom.dto.ProductTitleDTO;
import com.example.ecom.entities.Product;
import com.example.ecom.mappers.ProductMapper;
import com.example.ecom.repository.ProductRepository;
import com.sun.jdi.event.ExceptionEvent;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service("productService")
public class ProductService implements IProductService{

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<ProductTitleDTO> getAllProducts() throws IOException {
        return List.of();
    }

    @Override
    public ProductDTO getProductById(Long id) throws Exception {
        return repository.findById(id)
                .map(ProductMapper::toDTOFromEntity)
                .orElseThrow(() -> new Exception("Product not found"));
    }

    @Override
    public ProductDTO createProduct(ProductDTO dto) throws Exception {
        Product saved = repository.save(ProductMapper.toEntityFromDTO(dto));
        return ProductMapper.toDTOFromEntity(saved);
    }
}
