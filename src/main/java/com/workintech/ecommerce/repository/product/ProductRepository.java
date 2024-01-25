package com.workintech.ecommerce.repository.product;

import com.workintech.ecommerce.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM public.product WHERE category_id = :categoryId", nativeQuery = true)
    List<Product> findByCategoryId(@Param("categoryId") Integer categoryId);

    @Query(value = "SELECT COUNT(product_id) FROM public.product", nativeQuery = true)
    Integer getTotalProductNumber();
}