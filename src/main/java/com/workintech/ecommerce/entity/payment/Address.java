package com.workintech.ecommerce.entity.payment;

import com.workintech.ecommerce.entity.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "address", schema = "public")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    @NotBlank(message = "Address title cannot be empty.")
    @Size(max = 20, message = "Maximum character limit for address title (20) is exceeded.")
    private String title;

    @Column(name = "name")
    @NotBlank(message = "Name cannot be empty.")
    @Size(max = 20, message = "Maximum character limit for name (20) is exceeded.")
    private String name;

    @Column(name = "surname")
    @NotBlank(message = "Surname cannot be empty.")
    @Size(max = 20, message = "Maximum character limit for surname (20) is exceeded.")
    private String surname;

    @Column(name = "phone")
    @NotBlank(message = "Phone cannot be empty.")
    @Size(max = 15, message = "Maximum character limit for phone (15) is exceeded.")
    private String phone;

    @Column(name = "city")
    @NotBlank(message = "City cannot be empty.")
    @Size(max = 20, message = "Maximum character limit for city (20) is exceeded.")
    private String city;

    @Column(name = "district")
    @NotBlank(message = "District cannot be empty.")
    @Size(max = 30, message = "Maximum character limit for district (30) is exceeded.")
    private String district;

    @Column(name = "neighborhood")
    @NotBlank(message = "Neighborhood cannot be empty.")
    @Size(max = 50, message = "Maximum character limit for neighborhood (20) is exceeded.")
    private String neighborhood;

    @Column(name = "address")
    @NotBlank(message = "Address details cannot be empty.")
    private String address;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;
}
