package com.booking.flight.Repository;

import com.booking.flight.Service.Serviceinterface.PassengerService;
import com.booking.flight.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PassengerRepo extends JpaRepository<Passenger,Long> {
    Optional<Passenger> findById(Long id);
    Optional<Passenger> findByName(String name);

    @Query("SELECT p FROM Passenger p JOIN User u ON u.passenger = p WHERE u.id IN :userId")
    List<Passenger> findPassengerByUserId(@Param("userId") Long userId);





}
