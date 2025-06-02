package com.nicoletti.store.dtos;

import java.util.Set;

public record ProductDTO(
        Long id,
        String name,
        Double price,
        Set<CategoryDTO> categories
) {
}
