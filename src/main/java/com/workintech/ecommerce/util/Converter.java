package com.workintech.ecommerce.util;

import com.workintech.ecommerce.dto.product.*;
import com.workintech.ecommerce.dto.user.RoleRequest;
import com.workintech.ecommerce.dto.user.RoleResponse;
import com.workintech.ecommerce.dto.user.UserResponse;
import com.workintech.ecommerce.entity.product.Category;
import com.workintech.ecommerce.entity.product.Product;
import com.workintech.ecommerce.entity.product.Store;
import com.workintech.ecommerce.entity.user.Role;
import com.workintech.ecommerce.entity.user.User;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class Converter {
    public static List<CategoryResponse> categoryListConverter(List<Category> categories) {
        List<CategoryResponse> categoryResponses = new ArrayList<>();
        for (Category category : categories) {
            categoryResponses.add(categoryConverter(category));
        }
        return categoryResponses;
    }

    public static CategoryResponse categoryConverter(Category category) {
        return new CategoryResponse(category.getId(), category.getTitle(), category.getCode(), category.getGender(), category.getRating(), category.getImg());
    }


    public static Category categoryConverter(CategoryRequest categoryRequest, List<Product> products) {
        Category category = new Category();

        category.setTitle(categoryRequest.title());
        category.setCode(categoryRequest.code());
        category.setGender(categoryRequest.gender());
        category.setRating(categoryRequest.rating());
        category.setImg(categoryRequest.img());

        return category;
    }

    public static List<ProductResponse> productListConverter(List<Product> allProducts) {
        List<ProductResponse> products = new ArrayList<>();
        for (Product product : allProducts) {
            products.add(productConverter(product));
        }
        return products;
    }

    public static ProductResponse productConverter(Product product) {
        return new ProductResponse(product.getId(), product.getName(), product.getImages(), product.getDescription(), product.getPrice(), product.getRating(), product.getSellCount(), product.getStock(), product.getCategory().getId(), product.getStore().getId());
    }

    public static Product productConverter(ProductRequest productRequest, Category category, Store store) {
        Product product = new Product();

        product.setName(productRequest.name());
        product.setImages(productRequest.images());
        product.setDescription(productRequest.description());
        product.setPrice(productRequest.price());
        product.setRating(productRequest.rating());
        product.setSellCount(productRequest.sellCount());
        product.setStock(productRequest.stock());
        product.setCategory(category);
        product.setStore(store);

        return product;
    }

    public static StoreResponse storeConverter(Store store) {
        return new StoreResponse(store.getId(), store.getName());
    }

    public static Store storeConverter(StoreRequest storeRequest, List<Product> products) {
        Store store = new Store();

        store.setName(storeRequest.name());
        store.setProducts(products);

        return store;
    }

    public static UserResponse userConverter(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }

    public static RoleResponse roleConverter(Role role) {
        return new RoleResponse(role.getId(), role.getName(), role.getAuthority());
    }

    public static Role roleConverter(RoleRequest roleRequest) {
        Role role = new Role();

        role.setName(roleRequest.name());
        role.setAuthority(roleRequest.authority());

        return role;
    }

    public static List<RoleResponse> roleListConverter(List<Role> allRoles) {
        List<RoleResponse> roles = new ArrayList<>();
        for (Role role : allRoles) {
            roles.add(roleConverter(role));
        }
        return roles;
    }
}
