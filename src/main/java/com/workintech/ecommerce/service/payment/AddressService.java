package com.workintech.ecommerce.service.payment;

import com.workintech.ecommerce.dto.user.AddressRequest;
import com.workintech.ecommerce.dto.user.AddressResponse;

public interface AddressService {
    AddressResponse getAddress();
    AddressResponse addAddress(AddressRequest newAddress);
}
