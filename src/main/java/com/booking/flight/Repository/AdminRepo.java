package com.booking.flight.Repository;

import com.booking.flight.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepo extends JpaRepository<Admin,Long> {
    Optional<Admin> findByUsername(String userName);




}
