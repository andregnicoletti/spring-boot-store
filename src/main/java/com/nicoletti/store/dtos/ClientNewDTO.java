package com.nicoletti.store.dtos;

import com.nicoletti.store.enums.ClientType;
import com.nicoletti.store.utils.ValidationMessages;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

public record ClientNewDTO(

        @NotEmpty(message = ValidationMessages.Client.NAME_REQUIRED)
        @Length(min = 5, max = 80, message = ValidationMessages.Client.NAME_LENGTH)
        String name,

        @NotEmpty(message = ValidationMessages.Client.EMAIL_REQUIRED)
        @Email(message = ValidationMessages.Client.EMAIL_INVALID)
        String email,

        @NotEmpty(message = ValidationMessages.Client.DOCUMENT_REQUIRED)
        String document,

        ClientType clientType,

        Set<String> phones,

        Set<AddressDTO> addresses
) {
}
