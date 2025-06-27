package com.booking.flight.Repository;

import com.booking.flight.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface FlightRepo extends JpaRepository<Flight,Long> {
    Optional<Flight> findById(Long id);


    Optional<Flight> findByFlightname(String flightname);




    @Query(value = "Select * From flight Where airline = :airline",nativeQuery = true)
    Optional<Flight> getByAirline(@Param("airline") String airline);

    @Query(value = "SELECT * FROM flight WHERE source = :source AND destination = :destination", nativeQuery = true)
    List<Flight> searchFlightsNative(@Param("source") String source, @Param("destination") String destination);





}
