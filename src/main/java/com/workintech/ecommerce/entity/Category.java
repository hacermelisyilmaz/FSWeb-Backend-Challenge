package com.workintech.ecommerce.entity;

import com.workintech.ecommerce.util.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

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
    @NotBlank
    @Size(max = 20, message = "Maximum character limit 20 for category title is exceeded.")
    private String title;

    @Column(name = "code")
    @NotBlank
    @Size(max = 15, message = "Maximum character limit 15 for category code is exceeded.")
    private String code;

    @Enumerated(EnumType.STRING)
    @NotBlank
    private Gender gender;

    @Column(name = "img")
    @NotBlank
    @URL
    private String img;
}
