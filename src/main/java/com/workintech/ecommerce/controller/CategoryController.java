package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.dto.product.CategoryResponse;
import com.workintech.ecommerce.service.product.CategoryService;
import com.workintech.ecommerce.util.Converter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryResponse> getCategories() {
        return Converter.categoryListConverter(categoryService.getCategories());
    }
}
