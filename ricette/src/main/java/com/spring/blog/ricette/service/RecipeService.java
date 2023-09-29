package com.spring.blog.ricette.service;

import com.spring.blog.ricette.model.Recipe;
import com.spring.blog.ricette.repository.RecipeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    public RecipeService(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }
    public List<Recipe> getAll(){
        return recipeRepository.findAll();
    }
    public Recipe getById(Integer id){
        return recipeRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "No recipe")):
    }
    public void update(Recipe recipe){
        recipeRepository.save(recipe);
    }
    public void insert(Recipe recipe, boolean addDate){
        if (addDate) recipe.setDate(LocalDate.now());
        recipeRepository.save(recipe);
    }
    public void deleteById(Integer id){
        recipeRepository.deleteById(id);
    }
}
