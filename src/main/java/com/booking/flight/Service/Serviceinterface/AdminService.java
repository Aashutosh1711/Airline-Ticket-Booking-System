package com.booking.flight.Service.Serviceinterface;

import com.booking.flight.Dto.BookingDto;
import com.booking.flight.Dto.FlightDto;
import com.booking.flight.Dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface AdminService {

        FlightDto addFlight(FlightDto flightDto);
        FlightDto updateFlight(Long flightId, FlightDto flightDto);
        void deleteFlight(Long flightId);
        List<FlightDto> getAllFlights(String flightname);



        // Optional: User and analytics management
        Optional<UserDto> getAllUsers(UserDto userDto, String email);
        double getTotalRevenue();
    }