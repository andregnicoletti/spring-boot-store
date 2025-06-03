package com.nicoletti.store.dtos;

public record OrderItemDTO(
        Long productId,
        Integer quantity
) {
}
