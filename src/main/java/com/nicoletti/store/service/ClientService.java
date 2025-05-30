package com.nicoletti.store.service;

import com.nicoletti.store.dtos.ClientDTO;
import com.nicoletti.store.entities.Client;
import com.nicoletti.store.exceptions.ExceptionsCodes;
import com.nicoletti.store.exceptions.GenericException;
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

    @Transactional
    public List<Client> listAll() {
        return this.clientRepository.findAll();
    }

    @Transactional
    public ClientDTO findById(long id) {
        Client client = this.clientRepository.findById(id).orElseThrow(
                () -> new GenericException(ExceptionsCodes.CLIENT_ID_DOES_NOT_EXISTS, id));
        return clientMapper.toDto(client);
    }

    @Transactional
    public ClientDTO create(ClientDTO dto) {
        Optional<Client> byName = this.clientRepository.findByName(dto.name());
        if (byName.isEmpty()) {
            Client save = this.clientRepository.save(clientMapper.toEntity(dto));
            return clientMapper.toDto(save);
        }
        throw new GenericException(ExceptionsCodes.CLIENT_NAME_ALREADY_EXISTS, dto.name());
    }

    @Transactional
    public ClientDTO update(long id, ClientDTO dto) {
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
            throw new GenericException(ExceptionsCodes.COULD_NOT_DELETE_CLIENT, id);
        }
    }

    public Page<ClientDTO> findPage(Integer page, Integer size, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.valueOf(direction), orderBy);
        return clientRepository.findAll(pageRequest).map(clientMapper::toDto);
    }

}
