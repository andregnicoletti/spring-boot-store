package com.nicoletti.store.dtos;

import com.nicoletti.store.entities.Payment;

import java.util.List;

public record OrderInsertDTO(
        Long clientId,
        Long addressId,
        PaymentDTO payment,
        List<OrderItemDTO> itens
) {
}
