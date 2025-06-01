package com.nicoletti.store.dtos;

import com.nicoletti.store.utils.ValidationMessages;
import jakarta.validation.constraints.NotEmpty;

public record AddressDTO(

        Long id,

        @NotEmpty(message = ValidationMessages.Address.STREET_REQUIRED)
        String street,

        @NotEmpty(message = ValidationMessages.Address.NUMBER_REQUIRED)
        String number,

        String complement,

        @NotEmpty(message = ValidationMessages.Address.NEIGHBORHOOD_REQUIRED)
        String neighborhood,

        @NotEmpty(message = ValidationMessages.Address.POSTAL_CODE_REQUIRED)
        String postalCode,
        CityDTO city

) {
}
