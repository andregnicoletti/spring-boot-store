package com.nicoletti.store.service;

import com.nicoletti.store.entities.Category;
import com.nicoletti.store.exceptions.EntityNotFoundException;
import com.nicoletti.store.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> listAll() {
        return this.categoryRepository.findAll();
    }

    public Category findById(long id) {
        return this.categoryRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("Category id " + id + " does not exist."));
    }
}
