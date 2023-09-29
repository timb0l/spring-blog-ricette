package com.spring.blog.ricette.service;

import com.spring.blog.ricette.model.Category;
import com.spring.blog.ricette.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    public CategoryService getById(Integer id) {
        return categoryRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "No Category"));
    }
    public List<Category> getAll(){
        return categoryRepository.findAll();
    }
    public void update(Category category){
        categoryRepository.save(category);
    }
    public void insert(Category category){
        categoryRepository.save(category);
    }
    public void deleteById(Integer id){
        categoryRepository.deleteById(id);
    }
}
