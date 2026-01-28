package com.example.ecom.services;

import com.example.ecom.dto.CategoryDTO;
import com.example.ecom.entities.CategoryEntity;
import com.example.ecom.mappers.CategoryMapper;
import com.example.ecom.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) throws Exception {
        CategoryEntity category = CategoryMapper.toEntityFromDTO(categoryDTO);
        CategoryEntity saved = categoryRepository.save(category);
        return CategoryMapper.toDTOFromEntity(saved);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(category -> CategoryDTO.builder()
                        .Id(category.getId())
                        .name(category.getName())
                        .build()
                )

                .toList();
    }

    @Override
    public CategoryDTO getByName(String name) throws Exception {
        CategoryEntity category = categoryRepository.findByName(name)
                .orElseThrow(() -> new Exception("Category not found!"));

        return CategoryMapper.toDTOFromEntity(category);
    }
}
