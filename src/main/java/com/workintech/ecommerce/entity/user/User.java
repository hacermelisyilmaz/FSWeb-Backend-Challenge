package com.workintech.ecommerce.entity.user;

import com.workintech.ecommerce.entity.product.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user", schema = "public")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Name cannot be empty.")
    @Size(max = 50, message = "Maximum character limit for name (50) is exceeded.")
    private String name;

    @Column(name = "email")
    @NotBlank(message = "Email cannot be empty.")
    @Size(max = 50, message = "Maximum character limit for email (70) is exceeded.")
    @Email(message = "Invalid email address.")
    private String email;

    @Column(name = "password")
    @NotBlank(message = "Password cannot be empty.")
    private String password;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "user")
    private List<Address> addresses = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
