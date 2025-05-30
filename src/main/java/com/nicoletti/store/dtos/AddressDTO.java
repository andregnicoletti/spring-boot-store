package com.nicoletti.store.dtos;

public record AddressDTO(
        Long id,
        String street,
        String number,
        String complement,
        String neighborhood,
        String postalCode,
        CityDTO city

) {
}
