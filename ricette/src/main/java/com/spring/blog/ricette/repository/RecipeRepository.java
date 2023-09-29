package com.spring.blog.ricette.repository;

import com.spring.blog.ricette.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

}
