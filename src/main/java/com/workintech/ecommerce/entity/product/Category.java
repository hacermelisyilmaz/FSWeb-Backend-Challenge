package com.workintech.ecommerce.entity.product;

import com.workintech.ecommerce.util.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "category", schema = "public")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    @NotBlank(message = "Invalid category title.")
    @Size(max = 20, message = "Maximum character limit 20 for category title is exceeded.")
    private String title;

    @Column(name = "code")
    @NotBlank(message = "Invalid category code.")
    @Size(max = 15, message = "Maximum character limit 15 for category code is exceeded.")
    private String code;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Invalid category gender.")
    private Gender gender;

    @Column(name = "rating")
    @NotEmpty(message = "Category rating cannot be empty.")
    @Range(max = 5, min = 0, message = "Invalid category rating.")
    private Double rating;

    @Column(name = "img")
    @NotBlank(message = "Invalid category image.")
    @URL(message = "Invalid category image URL.")
    private String img;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "category")
    private List<Product> products = new ArrayList<>();
}
