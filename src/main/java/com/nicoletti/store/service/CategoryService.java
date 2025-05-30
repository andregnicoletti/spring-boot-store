package com.nicoletti.store.service;

import com.nicoletti.store.dtos.CategoryDTO;
import com.nicoletti.store.entities.Category;
import com.nicoletti.store.exceptions.ExceptionsCodes;
import com.nicoletti.store.exceptions.ServiceException;
import com.nicoletti.store.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryDTO> findAll() {
        return this.categoryRepository.findAll().stream()
                .map(i -> new CategoryDTO(i.getId(), i.getName()))
                .collect(Collectors.toList());
    }

    public CategoryDTO findById(long id) {
        Category category = this.categoryRepository.findById(id).orElseThrow(
                () -> new ServiceException(ExceptionsCodes.ID_CATEGORY_DOES_NOT_EXISTS, id));
        return new CategoryDTO(category.getId(), category.getName());
    }

    @Transactional
    public CategoryDTO create(CategoryDTO dto) {
        Optional<Category> byName = this.categoryRepository.findByName(dto.name());
        if (byName.isEmpty()) {
            Category save = this.categoryRepository.save(new Category(null, dto.name(), null));
            return new CategoryDTO(save.getId(), save.getName());
        }
        throw new ServiceException(ExceptionsCodes.CATEGORY_NAME_ALREADY_EXISTS, dto.name());
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
            throw new ServiceException(ExceptionsCodes.COULD_NOT_DELETE_CATEGORY, id, e.getMessage());
        }
    }
}
