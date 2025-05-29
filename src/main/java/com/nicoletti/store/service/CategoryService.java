package com.nicoletti.store.service;

import com.nicoletti.store.dtos.CategoryDTO;
import com.nicoletti.store.entities.Category;
import com.nicoletti.store.exceptions.ServiceException;
import com.nicoletti.store.exceptions.EntityNotFoundException;
import com.nicoletti.store.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> listAll() {
        return this.categoryRepository.findAll();
    }

    public Category findById(long id) {
        return this.categoryRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Category id " + id + " does not exist."));
    }

    @Transactional
    public CategoryDTO create(CategoryDTO dto) {
        Optional<Category> byName = this.categoryRepository.findByName(dto.name());
        if (byName.isEmpty()) {
            Category save = this.categoryRepository.save(new Category(null, dto.name(), null));
            return new CategoryDTO(save.getId(), save.getName());
        }
        throw new ServiceException("Category " + dto.name() + " name already exists.");
    }

    @Transactional
    public CategoryDTO update(long id, CategoryDTO dto) {
        Category category = this.findById(id);
        category.setName(dto.name());
        this.categoryRepository.save(category);
        return new CategoryDTO(category.getId(), category.getName());
    }

    public void delete(long id) {
        try {
            this.findById(id);
            categoryRepository.deleteById(id);
        } catch (Exception e) {
            throw new ServiceException("Erro ao deletar categoria: " + id );
        }
    }
}
