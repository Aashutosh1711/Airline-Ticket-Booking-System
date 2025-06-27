package com.booking.flight.Repository;

import com.booking.flight.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaymentRepo extends JpaRepository<Payment,Long> {
    Optional<Payment> findById(Long id);
//    Optional<Payment> findByTransactionId(Long transactionId);

//    List<Payment> findByUserId(Long userId);
}
