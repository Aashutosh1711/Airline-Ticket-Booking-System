package com.booking.flight.Service.Serviceinterface;

import com.booking.flight.Dto.FlightDto;

import java.util.List;
import java.util.Optional;

public interface FlightService {

    FlightDto addFlight(FlightDto flightDto);
    FlightDto UpdateFlight(FlightDto flightDto,Long id);
    Optional<FlightDto> getByName(String flightname);
    Optional<FlightDto> getByAirline(String airline);
    List<FlightDto> searchFlightNative(String source,String destination);


}
