package com.workintech.ecommerce.dto.product;

import java.util.Set;

public record ProductResponse(Long id, String name, Set<String> images, String description, Double price, Double rating, Integer sellCount, Integer stock, Integer category_id, Integer store_id) {
}
