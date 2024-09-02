package com.category.categoryservice.service;

import com.category.categoryservice.model.Category;
import com.category.categoryservice.repo.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepo categoryRepository;

    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
    public Optional<Category> getCategoryById(Long id) throws Exception {
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()) {
            return categoryRepository.findById(id);
        }
        else
            throw new Exception("Category not found");

    }
    public Boolean categoryExist(Long id) {return categoryRepository.existsById(id);}
}
