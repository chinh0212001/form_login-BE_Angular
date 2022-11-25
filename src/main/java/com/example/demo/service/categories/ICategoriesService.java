package com.example.demo.service.categories;

import com.example.demo.model.Categories;

import java.util.List;

public interface ICategoriesService {
    Boolean existsByName(String name);
    Categories save(Categories categories);
    List<Categories>findAll();
}
