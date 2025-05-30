package com.nicoletti.store.mappers;

import com.nicoletti.store.dtos.AddressDTO;
import com.nicoletti.store.entities.Address;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Set;

@Mapper(componentModel = "spring", uses = { CityMapper.class })
public interface AddressMapper {

    @Mapping(target = "city", source = "city")
    Address toEntity(AddressDTO dto);

    @Mapping(target = "city", source = "city")
    AddressDTO toDTO(Address entity);

    @AfterMapping
    default void validateCity(@MappingTarget Address address) {
        if (address.getCity() == null) {
            throw new IllegalArgumentException("City must not be null in Address");
        }
    }
}
