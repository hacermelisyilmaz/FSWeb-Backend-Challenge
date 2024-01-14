package com.workintech.ecommerce.repository.product;

import com.workintech.ecommerce.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
