package com.nicoletti.store.controllers;

import com.nicoletti.store.dtos.ProductDTO;
import com.nicoletti.store.dtos.ProductMinDTO;
import com.nicoletti.store.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

//    @GetMapping("/page")
//    public ResponseEntity<Page<ProductDTO>> findPage(
//            @RequestParam(value = "page", defaultValue = "0") Integer page,
//            @RequestParam(value = "size", defaultValue = "6") Integer size,
//            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
//            @RequestParam(value = "direction", defaultValue = "ASC") String direction
//    ) {
//        Page<ProductDTO> categories = productService.findPage(page, size, orderBy, direction);
//        return ResponseEntity.ok(categories);
//    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable long id) {
        ProductDTO category = productService.findById(id);
        return ResponseEntity.ok(category);
    }


}
