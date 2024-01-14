package com.workintech.ecommerce.service.user;

import com.workintech.ecommerce.dto.user.AddressRequest;
import com.workintech.ecommerce.dto.user.AddressResponse;

public interface AddressService {
    AddressResponse getAddress();
    AddressResponse addAddress(AddressRequest newAddress);
}
