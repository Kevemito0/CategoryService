package com.category.categoryservice.controller;

import com.category.categoryservice.model.Category;
import com.category.categoryservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/{categoryId}")
    private ResponseEntity<Category> getCategory(@PathVariable("categoryId") Long categoryId) throws Exception {
        Category category = categoryService.getCategoryById(categoryId).get();
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    @GetMapping("/{id}/validate")
    private ResponseEntity<Boolean> validateCategory(@PathVariable("id") Long id) {
        boolean exists = categoryService.categoryExist(id);
        return ResponseEntity.status(HttpStatus.OK).body(exists);
    }
    @PostMapping
    private ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category categor = categoryService.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(categor);
    }


}