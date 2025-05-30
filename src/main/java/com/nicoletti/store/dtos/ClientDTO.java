package com.nicoletti.store.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public record ClientDTO(

        Long id,

        @NotEmpty(message = "{client.name.notempty}")
        @Length(min = 5, max = 80, message = "{client.name.length}")
        String name,

        @NotEmpty(message = "{client.email.notempty}")
        @Email(message = "{client.email.invalid}")
        String email

) {
}
