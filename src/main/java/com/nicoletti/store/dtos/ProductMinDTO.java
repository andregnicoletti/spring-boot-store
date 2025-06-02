package com.nicoletti.store.dtos;

import java.util.Set;

public record ProductMinDTO(
        Long id,
        String name,
        Double price
) {
}
