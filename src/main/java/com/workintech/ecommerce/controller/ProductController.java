package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.dto.product.*;
import com.workintech.ecommerce.entity.product.Product;
import com.workintech.ecommerce.service.product.CategoryService;
import com.workintech.ecommerce.service.product.ProductService;
import com.workintech.ecommerce.service.product.StoreService;
import com.workintech.ecommerce.util.Converter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;
    private final StoreService storeService;

    @GetMapping
    public ProductsResponse getProducts(@RequestParam(name = "category", required = false) Integer categoryId,
                                        @RequestParam(name = "sort", required = false) String sort,
                                        @RequestParam(name = "filter", required = false) String filter) {
        List<Product> products = productService.findByRequestParams(categoryId, sort, filter);
        return new ProductsResponse(Converter.productListConverter(products), productService.getTotalProductNumber());
    }

    @GetMapping("/{productId}")
    public ProductResponse getProduct(@PathVariable Long productId) {
        return Converter.productConverter(productService.getProduct(productId));
    }

    @PostMapping
    public ProductResponse saveProduct(@RequestBody ProductRequest newProduct) {
        Product product = Converter.productConverter(newProduct,
                categoryService.getCategory(newProduct.category_id()),
                storeService.getStore(newProduct.store_id()));

        return Converter.productConverter(productService.save(product));
    }
}
