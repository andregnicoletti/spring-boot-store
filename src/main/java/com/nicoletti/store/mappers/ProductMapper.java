package com.nicoletti.store.mappers;

import com.nicoletti.store.dtos.AddressDTO;
import com.nicoletti.store.dtos.ProductDTO;
import com.nicoletti.store.dtos.ProductMinDTO;
import com.nicoletti.store.entities.Address;
import com.nicoletti.store.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDto(Product entity);

    Product toEntity(ProductDTO dto);

    List<ProductDTO> toDtoList(List<Product> entities);

    ProductMinDTO toDtoMin(Product entity);

    List<ProductMinDTO> toDtoMinList(List<Product> entities);

//    Set<Address> toEntity(Set<AddressDTO> dto);
//
//    Set<AddressDTO> toDto(Set<Address> entity);
//
//    void updateFromDto(Set<AddressDTO> dto, @MappingTarget Set<Address> entity);
//
}
