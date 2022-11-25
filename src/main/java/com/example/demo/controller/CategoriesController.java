package com.example.demo.controller;

import com.example.demo.dto.response.ResponMessage;
import com.example.demo.model.Categories;
import com.example.demo.model.User;
import com.example.demo.security.userprincal.UserDetailService;
import com.example.demo.service.categories.ICategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class CategoriesController {
    @Autowired
    ICategoriesService categoriesService;
    @Autowired
    UserDetailService userDetailService;
    @PostMapping("/create-category")
    public ResponseEntity<?>createCategory(@Valid @RequestBody Categories categories){
        User user = userDetailService.getCurrentUser();
        if (user.getUsername().equals("Anonymous")){
            return new ResponseEntity<>(new ResponMessage("chua login nhe !"),HttpStatus.OK);
        }
        if (categoriesService.existsByName(categories.getName())){
            return new ResponseEntity<>(new ResponMessage("category_invaild"), HttpStatus.OK);
        }
        if (categories.getAvatar().trim().equals("")){
            return new ResponseEntity<>(new ResponMessage("avatar_not"),HttpStatus.OK);
        }
        categoriesService.save(categories);
        return new ResponseEntity<>(new ResponMessage("create_success!!!"),HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<?>showListCategory(){
        List<Categories> listCategories= categoriesService.findAll();
        return new ResponseEntity<>(listCategories,HttpStatus.OK);
    }
}
