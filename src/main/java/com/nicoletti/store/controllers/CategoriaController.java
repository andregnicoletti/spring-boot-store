package com.nicoletti.store.controllers;

import com.nicoletti.store.entities.Category;
import com.nicoletti.store.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> listAll() {
        List<Category> categories = categoryService.listAll();
        return ResponseEntity.ok(categories);
    }

}
