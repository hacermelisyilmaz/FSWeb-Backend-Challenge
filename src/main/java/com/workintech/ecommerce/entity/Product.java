package com.workintech.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "product", schema = "public")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Product name cannot be empty.")
    @Size(max = 100, message = "Maximum character limit for product name (100) is exceeded.")
    private String name;

    @Column(name = "images")
    private Set<String> images;

    @Column(name = "description")
    @Size(max = 150, message = "Maximum character limit for product description (150) is exceeded.")
    private String description;

    @Column(name = "price")
    @NotEmpty(message = "Invalid product price value.")
    @Positive(message = "Product price must be positive.")
    private Double price;

    @Column(name = "rating")
    @Range(max = 5, min = 0, message = "Invalid product rating. Ratings are ranged between 0 and 5.")
    private Double rating;

    @Column(name = "sell_count")
    @PositiveOrZero(message = "Product sales count cannot be negative.")
    private Integer sellCount;

    @Column(name = "stock")
    @NotEmpty(message = "Invalid product stock value.")
    @PositiveOrZero(message = "Product stocks cannot be negative.")
    private Integer stock;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "category_id")
    private Store store;
}