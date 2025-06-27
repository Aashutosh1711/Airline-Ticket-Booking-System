package com.booking.flight.Repository;

import com.booking.flight.entity.Passenger;
import com.booking.flight.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findById(Long id);
    Optional<User> findByFullname(String fullname);

    Optional<User> findByEmail(String email);

//    List<Passenger> findPassengerByUserId(Long userId);
}
