package com.nicoletti.store.mappers;

import com.nicoletti.store.dtos.ClientMinDTO;
import com.nicoletti.store.dtos.ClientNewDTO;
import com.nicoletti.store.entities.Client;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = { AddressMapper.class })
public interface ClientMapper {

    Client toEntity(ClientMinDTO dto);

    Client toEntity(ClientNewDTO dto);

    ClientMinDTO toDto(Client entity);

    List<ClientNewDTO> toDtoList(List<Client> entities);

    List<Client> toEntityList(List<ClientNewDTO> dtos);

    @Mapping(target = "id", ignore = true)
    void updateClientFromDto(ClientMinDTO dto, @MappingTarget Client entity);

    @AfterMapping
    default void linkClient(@MappingTarget Client client) {
        if (client.getAddresses() != null) {
            client.getAddresses().forEach(address -> address.setClient(client));
        }
    }
}
