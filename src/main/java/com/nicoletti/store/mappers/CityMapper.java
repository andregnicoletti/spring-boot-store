package com.nicoletti.store.mappers;

import com.nicoletti.store.dtos.CityDTO;
import com.nicoletti.store.entities.City;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper {

    City toEntity(CityDTO dto);

    CityDTO toDTO(City entity);

}
