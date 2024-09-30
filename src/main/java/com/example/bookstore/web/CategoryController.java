package com.example.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.bookstore.CategoryRepository;
import com.example.bookstore.domain.Category;

@Controller
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categorylist")
    public String categoryList(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "categorylist"; // categorylist.html
    }

    @GetMapping("/addcategory")
    public String addCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory"; // addcategory.html
    }

    @PostMapping("/savecategory")
    public String saveCategory(Category category) {
        categoryRepository.save(category);
        return "redirect:/categorylist";
    }
}
