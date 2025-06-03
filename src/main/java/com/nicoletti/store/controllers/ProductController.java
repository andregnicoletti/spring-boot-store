package com.nicoletti.store.controllers;

import com.nicoletti.store.dtos.ProductDTO;
import com.nicoletti.store.dtos.ProductFindDTO;
import com.nicoletti.store.dtos.ProductMinDTO;
import com.nicoletti.store.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/produtos")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductMinDTO>> findAll() {
        List<ProductMinDTO> categories = productService.findAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable long id) {
        ProductDTO category = productService.findById(id);
        return ResponseEntity.ok(category);
    }

    @PostMapping("/search")
    public ResponseEntity<Page<ProductMinDTO>> findPage(
            @RequestBody ProductFindDTO productFindDTO,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "6") Integer size,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction
    ) {
        Page<ProductMinDTO> categoriesDTO = productService.findPage(productFindDTO, page, size, orderBy, direction);
        return ResponseEntity.ok(categoriesDTO);
    }


}
