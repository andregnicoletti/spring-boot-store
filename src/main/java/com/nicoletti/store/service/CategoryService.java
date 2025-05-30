package com.nicoletti.store.service;

import com.nicoletti.store.dtos.CategoryDTO;
import com.nicoletti.store.entities.Category;
import com.nicoletti.store.exceptions.ExceptionsCodes;
import com.nicoletti.store.exceptions.GenericException;
import com.nicoletti.store.mappers.CategoryMapper;
import com.nicoletti.store.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public List<CategoryDTO> findAll() {
        return this.categoryRepository.findAll().stream()
                .map(category -> categoryMapper.toDto(category))
                .collect(Collectors.toList());
    }

    public CategoryDTO findById(long id) {
        Category category = this.categoryRepository.findById(id).orElseThrow(
                () -> new GenericException(ExceptionsCodes.ID_CATEGORY_DOES_NOT_EXISTS, id));
        return categoryMapper.toDto(category);
    }

    @Transactional
    public CategoryDTO create(CategoryDTO dto) {
        Optional<Category> byName = this.categoryRepository.findByName(dto.name());
        if (byName.isEmpty()) {
            Category save = this.categoryRepository.save(new Category(null, dto.name(), null));
            return categoryMapper.toDto(save);
        }
        throw new GenericException(ExceptionsCodes.CATEGORY_NAME_ALREADY_EXISTS, dto.name());
    }

    @Transactional
    public CategoryDTO update(long id, CategoryDTO dto) {
        this.findById(id);
        Category category = categoryRepository.findById(id).get();
        category.setName(dto.name());
        this.categoryRepository.save(category);
        return categoryMapper.toDto(category);
    }

    public void delete(long id) {
        try {
            this.findById(id);
            categoryRepository.deleteById(id);
        } catch (Exception e) {
            throw new GenericException(ExceptionsCodes.COULD_NOT_DELETE_CATEGORY, id, e.getMessage());
        }
    }

    public Page<CategoryDTO> findPage(Integer page, Integer size, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.valueOf(direction), orderBy);
        return categoryRepository.findAll(pageRequest).map(categoryMapper::toDto);
    }



}
