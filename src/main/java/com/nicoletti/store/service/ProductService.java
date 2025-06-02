package com.nicoletti.store.service;

import com.nicoletti.store.dtos.ProductDTO;
import com.nicoletti.store.dtos.ProductMinDTO;
import com.nicoletti.store.entities.Product;
import com.nicoletti.store.exceptions.GenericException;
import com.nicoletti.store.mappers.ProductMapper;
import com.nicoletti.store.repositories.ProductRepository;
import com.nicoletti.store.utils.ExceptionsErrors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Transactional
    public ProductDTO findById(long id) {
        Product product = this.productRepository.findById(id).orElseThrow(
                () -> new GenericException(ExceptionsErrors.PRODUCT_ID_DOES_NOT_EXISTS, id));
        return productMapper.toDto(product);
    }

    public List<ProductMinDTO> findAll() {
        List<Product> all = this.productRepository.findAll();
        return productMapper.toDtoMinList(all);
    }
}
