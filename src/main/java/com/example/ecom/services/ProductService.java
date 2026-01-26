package com.example.ecom.services;

import com.example.ecom.dto.ProductDTO;
import com.example.ecom.dto.ProductTitleDTO;
import com.example.ecom.dto.ProductWithCategoryDTO;
import com.example.ecom.entities.CategoryEntity;
import com.example.ecom.entities.ProductEntity;
import com.example.ecom.mappers.ProductMapper;
import com.example.ecom.repository.CategoryRepository;
import com.example.ecom.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service("productService")
public class ProductService implements IProductService{

    private final ProductRepository repository;

    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository repository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
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
        CategoryEntity category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new Exception("Category not found"));

        ProductEntity saved = repository.save(ProductMapper.toEntityFromDTO(dto, category));
        return ProductMapper.toDTOFromEntity(saved);
    }

    @Override
    public ProductWithCategoryDTO getProductWithCategory(long id) throws Exception{

        ProductEntity product = repository.findById(id)
                .orElseThrow(() -> new Exception(("Product not found!")));
        return ProductMapper.toProductWithCategoryDTO(product);
    }
}
