package com.nicoletti.store.mappers;

import com.nicoletti.store.dtos.AddressDTO;
import com.nicoletti.store.entities.Address;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Set<Address> toEntity(Set<AddressDTO> dto);

    Set<AddressDTO> toDto(Set<Address> entity);

    void updateFromDto(Set<AddressDTO> dto, @MappingTarget Set<Address> entity);

}
