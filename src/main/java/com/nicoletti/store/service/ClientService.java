package com.nicoletti.store.service;

import com.nicoletti.store.dtos.ClientDTO;
import com.nicoletti.store.dtos.ClientMinDTO;
import com.nicoletti.store.dtos.ClientNewDTO;
import com.nicoletti.store.entities.Client;
import com.nicoletti.store.utils.ExceptionsErrors;
import com.nicoletti.store.exceptions.GenericException;
import com.nicoletti.store.mappers.AddressMapper;
import com.nicoletti.store.mappers.ClientMapper;
import com.nicoletti.store.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final AddressMapper addressMapper;

    @Transactional
    public List<ClientDTO> listAll() {
        return clientMapper.toDtoFullList(this.clientRepository.findAll());
    }

    @Transactional
    public ClientMinDTO findById(long id) {
        Client client = this.clientRepository.findById(id).orElseThrow(
                () -> new GenericException(ExceptionsErrors.CLIENT_ID_DOES_NOT_EXISTS, id));
        return clientMapper.toDto(client);
    }

    @Transactional
    public ClientMinDTO create(ClientNewDTO dto) {
        Optional<Client> byName = this.clientRepository.findByName(dto.name());
        if (byName.isEmpty()) {
            Client entity = this.clientMapper.toEntity(dto);
            entity.getAddresses().stream().forEach(address -> address.setId(null));
            Client save = this.clientRepository.save(entity);
            return clientMapper.toDto(save);
        }
        throw new GenericException(ExceptionsErrors.CLIENT_NAME_ALREADY_EXISTS, dto.name());
    }

    @Transactional
    public ClientMinDTO update(long id, ClientMinDTO dto) {
        this.findById(id);
        Client Client = clientRepository.findById(id).get();
        Client.setName(dto.name());
        this.clientRepository.save(Client);
        return clientMapper.toDto(Client);
    }

    public void delete(long id) {
        try {
            this.findById(id);
            clientRepository.deleteById(id);
        } catch (Exception e) {
            throw new GenericException(ExceptionsErrors.COULD_NOT_DELETE_CLIENT, id);
        }
    }

    public Page<ClientMinDTO> findPage(Integer page, Integer size, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.valueOf(direction), orderBy);
        return clientRepository.findAll(pageRequest).map(clientMapper::toDto);
    }

}
