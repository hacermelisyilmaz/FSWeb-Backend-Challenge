package com.workintech.ecommerce.entity.user;

import com.workintech.ecommerce.entity.product.Product;
import com.workintech.ecommerce.entity.product.Store;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "role", schema = "public")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    @NotBlank(message = "Role code is invalid.")
    @Size(max = 10, message = "Maximum character limit (10) for the role code is exceeded.")
    private String authority;

    @Column(name = "name")
    @NotBlank(message = "Role name is invalid.")
    @Size(max = 10, message = "Maximum character limit (10) for the role name is exceeded.")
    private String name;
}