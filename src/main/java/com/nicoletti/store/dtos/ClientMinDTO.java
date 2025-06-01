package com.nicoletti.store.dtos;

import com.nicoletti.store.utils.ValidationMessages;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public record ClientMinDTO(

        Long id,

        @NotEmpty(message = ValidationMessages.Client.NAME_REQUIRED)
        @Length(min = 5, max = 80, message = ValidationMessages.Client.NAME_LENGTH)
        String name,

        @NotEmpty(message = ValidationMessages.Client.EMAIL_REQUIRED)
        @Email(message = ValidationMessages.Client.EMAIL_INVALID)
        String email

) {
}
