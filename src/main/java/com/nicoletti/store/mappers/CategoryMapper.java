package com.nicoletti.store.mappers;

import com.nicoletti.store.dtos.CategoryDTO;
import com.nicoletti.store.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toEntity(CategoryDTO dto);

    CategoryDTO toDto(Category entity);

    // Atualização: aplica dados do DTO em uma entidade existente
    void updateGameFromDto(CategoryDTO dto, @MappingTarget Category entity);

}
