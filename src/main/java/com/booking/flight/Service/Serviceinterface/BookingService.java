package com.booking.flight.Service.Serviceinterface;

import com.booking.flight.Dto.BookingDto;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    BookingDto bookFlight(BookingDto bookingDto);
    Optional<BookingDto> getById(Long id);
    Page<BookingDto> getAll(Pageable pageable);
    BookingDto cancelFlight(Long id);

}
