package com.spring.blog.ricette.controller;

import com.spring.blog.ricette.model.Recipe;
import com.spring.blog.ricette.repository.RecipeRepository;
import com.spring.blog.ricette.service.RecipeService;
import com.spring.blog.ricette.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;
    private final CategoryService categoryService;
    public RecipeController(RecipeService recipeService, CategoryService categoryService){
        this.recipeService = recipeService;
        this.categoryService = categoryService;
    }
    @Autowired
    private RecipeRepository recipeRepository;
    @GetMapping
    public String index (Model model){
        model.addAttribute("recipeList", recipeService.getAll());
        return "recipe/index";
    }

    @GetMapping("/create")
    public String create (Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return "recipe/form";
    }

    @PostMapping("/create")
    public String create (Model model, @Valid @ModelAttribute Recipe recipe, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.getAll());
            return "recipe/form";
        }
        recipeService.insert(recipe, true);
        return "redirect:/recipe";
    }

    @GetMapping("/edit/{id}")
    public String edit (Model model, @PathVariable Integer id){
        model.addAttribute("recipe", recipeService.getAll());
        model.addAttribute("categories", categoryService.getAll());
        return "recipe:/form";
    }
    @PostMapping("/edit/{id}")
    public String edit (Model model, @PathVariable Integer id, @Valid @ModelAttribute Recipe recipe, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
        model.addAttribute("categories", categoryService.getAll());
            return "recipe/form";
        }
        recipeService.update(recipe);
        return "redirect:/recipe";
    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        recipeService.deleteById(id);
        return "redirect:/recipe";
    }
}
