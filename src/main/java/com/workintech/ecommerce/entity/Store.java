package com.workintech.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "store", schema = "public")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    @NotBlank(message = "Store name cannot be empty.")
    @Size(max = 20, message = "Maximum character limit for store name (20) is exceeded.")
    private String name;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "store")
    private List<Product> products = new ArrayList<>();
}
