package com.workintech.ecommerce.dto.product;

import java.util.List;

public record ProductsResponse(List<ProductResponse> productsResponseList, Integer totalCount) {
}
