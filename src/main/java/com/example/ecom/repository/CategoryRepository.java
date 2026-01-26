package com.example.ecom.repository;

import com.example.ecom.entities.CategoryEntity;
import com.example.ecom.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository  extends JpaRepository<CategoryEntity, Long> {

    // jpa is so smart that it automatically understands that this is a DB call you want to expose.
    Optional<CategoryEntity> findByName(String name);



}
