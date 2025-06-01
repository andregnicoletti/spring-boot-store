package com.nicoletti.store.dtos;

import com.nicoletti.store.utils.ValidationMessages;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record CategoryDTO(

        Long id,

        @NotEmpty(message = ValidationMessages.Category.NAME_REQUIRED)
        @Length(min = 5, max = 80, message = ValidationMessages.Category.NAME_LENGTH)
        String name

) {
}
