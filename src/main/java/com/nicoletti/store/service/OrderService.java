package com.nicoletti.store.service;

import com.nicoletti.store.entities.Order;
import com.nicoletti.store.utils.ExceptionsErrors;
import com.nicoletti.store.exceptions.GenericException;
import com.nicoletti.store.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public List<Order> listAll() {
        return this.orderRepository.findAll();
    }

    @Transactional
    public Order findById(long id) {
        return this.orderRepository.findById(id).orElseThrow(
                () -> new GenericException(ExceptionsErrors.ORDER_ID_DOES_NOT_EXISTS, id));
    }
}
