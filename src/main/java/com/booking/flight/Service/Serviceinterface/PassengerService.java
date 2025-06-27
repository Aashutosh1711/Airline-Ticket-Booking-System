package com.booking.flight.Service.Serviceinterface;

import com.booking.flight.Dto.PassengerDto;

import java.util.List;
import java.util.Optional;

public interface PassengerService {
    PassengerDto addPassenger(PassengerDto passengerDto);
    PassengerDto updatePassenger(PassengerDto passengerDto,Long id);
    PassengerDto deletePassenger(Long id);
    Optional<PassengerDto> getPassenger(String name);
    List<PassengerDto> getPassengersByUserId(Long userId);


}
