package com.nicoletti.store.service;

import com.nicoletti.store.entities.Client;
import com.nicoletti.store.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Transactional
    public List<Client> listAll() {
        return this.clientRepository.findAll();
    }

    @Transactional
    public Client findById(long id) {
        return this.clientRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("Client id " + id + " does not exist."));
    }
}
