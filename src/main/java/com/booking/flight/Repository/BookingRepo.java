package com.booking.flight.Repository;

import com.booking.flight.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking,Long> {

}

