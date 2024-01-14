package com.workintech.ecommerce.service.product;

import com.workintech.ecommerce.dto.product.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getProducts();
    ProductResponse getProduct(Long id);
}
