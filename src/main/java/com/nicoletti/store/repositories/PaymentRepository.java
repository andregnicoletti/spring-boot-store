package com.nicoletti.store.repositories;

import com.nicoletti.store.entities.Order;
import com.nicoletti.store.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
