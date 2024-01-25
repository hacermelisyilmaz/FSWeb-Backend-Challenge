package com.workintech.ecommerce.dto.payment;

public record AddressRequest(String title, String name, String surname, String phone, String city, String district, String neighborhood, String address) {
}
