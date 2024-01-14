package com.workintech.ecommerce.repository.product;

import com.workintech.ecommerce.entity.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
