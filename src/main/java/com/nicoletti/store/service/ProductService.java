package com.nicoletti.store.service;

import com.nicoletti.store.dtos.CategoryDTO;
import com.nicoletti.store.dtos.ProductDTO;
import com.nicoletti.store.dtos.ProductFindDTO;
import com.nicoletti.store.dtos.ProductMinDTO;
import com.nicoletti.store.entities.Category;
import com.nicoletti.store.entities.Product;
import com.nicoletti.store.exceptions.GenericException;
import com.nicoletti.store.mappers.ProductMapper;
import com.nicoletti.store.repositories.CategoryRepository;
import com.nicoletti.store.repositories.ProductRepository;
import com.nicoletti.store.utils.ExceptionsErrors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    @Transactional(readOnly = true)
    public ProductDTO findById(long id) {
        Product product = this.productRepository.findById(id).orElseThrow(
                () -> new GenericException(ExceptionsErrors.PRODUCT_ID_DOES_NOT_EXISTS, id));
        return productMapper.toDto(product);
    }

    @Transactional(readOnly = true)
    public List<ProductMinDTO> findAll() {
        List<Product> all = this.productRepository.findAll();
        return productMapper.toDtoMinList(all);
    }

    @Transactional(readOnly = true)
    public Page<ProductMinDTO> findPage(ProductFindDTO productFindDTO, Integer page, Integer size, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.valueOf(direction), orderBy);
        List<Category> categories = categoryRepository.findAllById(productFindDTO.categoriesId());
        Page<Product> search = productRepository.findDistinctByNameContainingAndCategoriesIn(productFindDTO.name(), categories, pageRequest);
        return search.map(productMapper::toDtoMin);
    }
}
