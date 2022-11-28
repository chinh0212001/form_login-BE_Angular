package com.example.demo.service.categories;

import com.example.demo.model.Categories;
import com.example.demo.model.User;
import com.example.demo.repository.ICategoriesRepository;
import com.example.demo.security.userprincal.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesServiceIMPL implements ICategoriesService{
    @Autowired
    ICategoriesRepository categoriesRepository;
    @Autowired
    UserDetailService userDetailService;

    @Override
    public Boolean existsByName(String name) {
        return categoriesRepository.existsByName(name);
    }

    @Override
    public Categories save(Categories categories) {
        User user = userDetailService.getCurrentUser();
        categories.setUser(user);
        return categoriesRepository.save(categories);
    }

    @Override
    public List<Categories> findAll() {
        return categoriesRepository.findAll();
    }

    @Override
    public Optional<Categories> findById(Long id) {
       return categoriesRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        categoriesRepository.deleteById(id);
    }
}
