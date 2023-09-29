package com.spring.blog.ricette.controller;

import com.spring.blog.ricette.model.Category;
import com.spring.blog.ricette.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @GetMapping
    public String categories(Model model){
        model.addAttribute("categories", categoryService.getAll());
        return "categories/index";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("category", new Category());
        return "categories/form";
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "categories/form";
        }
        categoryService.insert(category);
        return "redirect:/categories";
    }
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Integer id){
        model.addAttribute("category", categoryService.getById(id));
        return "categories/form";
    }
    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, @Valid @ModelAttribute Category category, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return "categories/form";
        categoryService.update(category);
        return "redirect:/categories";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        categoryService.deleteById(id);
        return "redirect:/categories";
    }


}


