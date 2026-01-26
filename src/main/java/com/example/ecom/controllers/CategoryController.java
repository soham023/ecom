package com.example.ecom.controllers;

import com.example.ecom.dto.CategoryDTO;
import com.example.ecom.services.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/category")
public class CategoryController {


    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
//  why ResponseEntity<?> ? -> generic response wrapper
//  if name mentioned want 1 category(CategoryDTO)
//    if name not mentioned then want to return list of categories(List<CategoryDTO>)
    public ResponseEntity<?> getAllCategories(@RequestParam(required = false) String name) throws Exception {
        if (name != null && !name.isBlank()) {
            CategoryDTO categoryDTO = categoryService.getByName(name);
            return ResponseEntity.ok(categoryDTO);
        } else {
            List<CategoryDTO> result = this.categoryService.getAllCategories();
            return ResponseEntity.ok(result);
        }
    }

    @PostMapping("/createCategory")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) throws Exception {
        CategoryDTO createCategory = this.categoryService.createCategory(categoryDTO);
        return ResponseEntity.ok(createCategory);
    }
}
