package com.nicoletti.store.mappers;

import com.nicoletti.store.dtos.CategoryDTO;
import com.nicoletti.store.dtos.ClientDTO;
import com.nicoletti.store.entities.Category;
import com.nicoletti.store.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client toEntity(ClientDTO dto);

    ClientDTO toDto(Client entity);

    // Atualização: aplica dados do DTO em uma entidade existente
    void updateGameFromDto(ClientDTO dto, @MappingTarget Client entity);

}
