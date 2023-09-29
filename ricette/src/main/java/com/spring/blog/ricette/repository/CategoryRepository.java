package com.spring.blog.ricette.repository;

import com.spring.blog.ricette.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
