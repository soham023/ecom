package com.example.ecom.services;

import com.example.ecom.dto.CategoryDTO;

import java.util.List;

public interface ICategoryService {
    CategoryDTO createCategory(CategoryDTO categoryDTO) throws Exception;
    List<CategoryDTO> getAllCategories() throws Exception;

    CategoryDTO getByName(String name) throws Exception;
}
