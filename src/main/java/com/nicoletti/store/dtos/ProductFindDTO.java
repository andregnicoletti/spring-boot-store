package com.nicoletti.store.dtos;

import java.util.List;

public record ProductFindDTO(
        String name,
        List<Long> categoriesId
) {
}
