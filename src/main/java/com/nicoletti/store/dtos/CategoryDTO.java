package com.nicoletti.store.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record CategoryDTO(

        Long id,

        @NotEmpty(message = "{category.name.notempty}")
        @Length(min = 5, max = 80, message = "{category.name.length}")
        String name

) {
}
