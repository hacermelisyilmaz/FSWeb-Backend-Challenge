package com.workintech.ecommerce.repository.payment;

import com.workintech.ecommerce.entity.payment.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
