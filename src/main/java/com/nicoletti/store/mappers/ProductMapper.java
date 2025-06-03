package com.nicoletti.store.mappers;

import com.nicoletti.store.dtos.AddressDTO;
import com.nicoletti.store.dtos.ProductDTO;
import com.nicoletti.store.dtos.ProductMinDTO;
import com.nicoletti.store.entities.Address;
import com.nicoletti.store.entities.Category;
import com.nicoletti.store.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDto(Product entity);

    Product toEntity(ProductDTO dto);

    List<ProductDTO> toDtoList(List<Product> entities);

    @Mapping(target = "categoriesId", expression = "java(mapCategoriesToIds(entity.getCategories()))")
    ProductMinDTO toDtoMin(Product entity);

    List<ProductMinDTO> toDtoMinList(List<Product> entities);

    // Método auxiliar para mapear o Set<Category> -> Set<Long>
    default Set<Long> mapCategoriesToIds(Set<Category> categories) {
        if (categories == null) return null;
        return categories.stream()
                .map(Category::getId)
                .collect(java.util.stream.Collectors.toSet());
    }
}
