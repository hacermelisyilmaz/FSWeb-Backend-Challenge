package com.workintech.ecommerce.entity.payment;

import com.workintech.ecommerce.entity.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "address", schema = "public")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number")
    @NotEmpty(message = "You must enter a credit/debit card number.")
    @Size(max = 16, min = 16, message = "Credit card number must consist of 16 digits.")
    private Long number;

    @Column(name = "exp_month")
    @NotEmpty(message = "You must enter expiration date.")
    @Size(max = 2, min = 2, message = "Please enter a valid month.")
    private Integer expMonth;

    @Column(name = "exp_year")
    @NotEmpty(message = "You must enter expiration date.")
    @Size(max = 2, min = 2, message = "Please enter the last two digits of the expiration year.")
    private Integer expYear;


    @Column(name = "cvv")
    @NotEmpty(message = "You must enter CVV.")
    @Size(max = 3, min = 3, message = "CVV field cannot be empty.")
    private Integer cvv;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;
}
