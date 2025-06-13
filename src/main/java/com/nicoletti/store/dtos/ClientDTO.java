package com.nicoletti.store.dtos;

import com.nicoletti.store.enums.ClientType;

import java.util.Set;

public record ClientDTO(
        Long id,
        String name,
        String email,
        String document,
        ClientType clientType,
        Set<String> phones,
        Set<AddressDTO> addresses
) {
}
