package com.workintech.ecommerce.service.product;

import com.workintech.ecommerce.entity.product.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    Category getCategory(Integer id);
}
