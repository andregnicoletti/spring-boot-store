package com.nicoletti.store.repositories;

import com.nicoletti.store.entities.Category;
import com.nicoletti.store.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("""
            SELECT DISTINCT obj 
                FROM Product obj INNER JOIN obj.categories cat 
                WHERE obj.name LIKE %:name% AND cat IN :categories
            """ )
    Page<Product> search(@Param("name") String name, @Param("categories") List<Category> categories, PageRequest pageRequest);

    Page<Product> findDistinctByNameContainingAndCategoriesIn(String name, List<Category> categories, PageRequest pageRequest);
}
