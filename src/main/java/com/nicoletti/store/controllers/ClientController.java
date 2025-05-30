package com.nicoletti.store.controllers;

import com.nicoletti.store.dtos.ClientDTO;
import com.nicoletti.store.entities.Client;
import com.nicoletti.store.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> listAll() {
        List<Client> clients = clientService.listAll();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable long id) {
        ClientDTO category = clientService.findById(id);
        return ResponseEntity.ok(category);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> createCategory(@Valid @RequestBody ClientDTO dto) {
        ClientDTO category = clientService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(category.id())
                .toUri();
        return ResponseEntity.created(uri).body(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> updateCategory(@PathVariable long id, @Valid @RequestBody ClientDTO dto) {
        ClientDTO client = clientService.update(id, dto);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> updateclient(@PathVariable long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
    

}
