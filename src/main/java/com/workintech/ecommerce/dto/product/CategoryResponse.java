package com.workintech.ecommerce.dto.product;

import com.workintech.ecommerce.util.Gender;

public record CategoryResponse(Integer id, String title, String code, Gender gender, Double rating, String img) {
}
