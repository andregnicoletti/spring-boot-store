package com.nicoletti.store.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @GetMapping
    public ResponseEntity<String> listAll() {
        return ResponseEntity.ok("Teste ok");
    }

}
