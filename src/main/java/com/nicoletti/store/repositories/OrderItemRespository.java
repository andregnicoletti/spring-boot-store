package com.nicoletti.store.repositories;

import com.nicoletti.store.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRespository extends JpaRepository<OrderItem, Long> {
}
