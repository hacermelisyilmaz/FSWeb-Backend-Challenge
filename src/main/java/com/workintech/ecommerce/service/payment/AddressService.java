package com.workintech.ecommerce.service.payment;

import com.workintech.ecommerce.dto.payment.AddressRequest;
import com.workintech.ecommerce.entity.payment.Address;

public interface AddressService {
    Address getAddress();
    Address addAddress(AddressRequest newAddress);
}
