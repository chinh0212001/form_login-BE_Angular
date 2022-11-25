package com.example.demo.repository;

import com.example.demo.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICategoriesRepository extends JpaRepository<Categories,Long> {
    Boolean existsByName(String name);

}
