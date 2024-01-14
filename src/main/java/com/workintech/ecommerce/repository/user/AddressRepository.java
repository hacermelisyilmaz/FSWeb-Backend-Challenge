package com.workintech.ecommerce.repository.user;

import com.workintech.ecommerce.entity.user.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
