package com.workintech.ecommerce.service.product;

import com.workintech.ecommerce.entity.product.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product getProduct(Long id);
    Integer getTotalProductNumber();

    Product save(Product product);
    List<Product> saveAll(List<Product> products);

    Product delete(Long id);

    List<Product> findByCategoryId(Integer categoryId);

    List<Product> findByRequestParams(Integer categoryId, String sort, String filter);
}
