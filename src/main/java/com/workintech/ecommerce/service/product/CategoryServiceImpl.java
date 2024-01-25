package com.workintech.ecommerce.service.product;

import com.workintech.ecommerce.dto.product.CategoryResponse;
import com.workintech.ecommerce.entity.product.Category;
import com.workintech.ecommerce.repository.product.CategoryRepository;
import com.workintech.ecommerce.util.Converter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Integer id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) categoryOptional.get();
        return null;
        // TODO handle exception
    }
}
