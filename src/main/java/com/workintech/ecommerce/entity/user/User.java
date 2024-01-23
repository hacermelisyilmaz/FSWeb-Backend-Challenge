package com.workintech.ecommerce.entity.user;

import com.workintech.ecommerce.entity.payment.Address;
import com.workintech.ecommerce.entity.payment.Card;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

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

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "user")
    private List<Card> cards = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", schema = "public",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> authorities = new HashSet<>();

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        //TODO email verification ekle
        return true;
    }
}
