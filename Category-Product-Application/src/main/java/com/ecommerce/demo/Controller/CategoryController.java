package com.ecommerce.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.demo.Service.CategoryService;
import com.ecommerce.demo.entity.Category;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

//    @Autowired
//    public CategoryController(CategoryService categoryService) {
//        this.categoryService = categoryService;
//    }
    
    @PostMapping
    public Category createCategory(@RequestBody Category category ) {
    	return categoryService.saveCategory(category);
    }
    
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
    	return categoryService.getCategoryById(id);
    }
    @GetMapping
    public List<Category> getAllCategories(@RequestParam("page") int page){
    	return categoryService.getAllCategories();
    }
    
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
    
    @PutMapping("/{id}")
    public Category updateCategory(@RequestBody Category category ) {
    	return categoryService.saveCategory(category);
    }
}
