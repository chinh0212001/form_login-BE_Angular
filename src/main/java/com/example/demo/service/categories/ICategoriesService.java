package com.example.demo.service.categories;

import com.example.demo.model.Categories;

import java.util.List;
import java.util.Optional;

public interface ICategoriesService {
    Boolean existsByName(String name);
    Categories save(Categories categories);
    List<Categories>findAll();
    Optional<Categories>findById(Long id);
    void delete(Long id);
}
