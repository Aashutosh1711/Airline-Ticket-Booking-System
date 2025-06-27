package com.booking.flight.Controller;

import com.booking.flight.Dto.FlightDto;
import com.booking.flight.Service.FlightServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/air-line/flight")
public class FlightController {

    private FlightServiceImpl flightService;

    public FlightController(FlightServiceImpl flightService) {
        this.flightService = flightService;
    }

    @PostMapping("/save-flight")
    public ResponseEntity<FlightDto> saveFlight(@RequestBody FlightDto flightDto) {
        FlightDto flightDto1 = flightService.addFlight(flightDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(flightDto1);
    }

    @PutMapping("update-flight/{id}")
    public ResponseEntity<FlightDto> updateFlight(@RequestBody FlightDto flightDto, @PathVariable Long id) {
        FlightDto flightDto2 = flightService.UpdateFlight(flightDto, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(flightDto2);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Optional<FlightDto>> getname(@PathVariable String name){
        Optional<FlightDto> flightDto3=flightService.getByName(name);
        return ResponseEntity.ok(flightDto3);
    }


    @GetMapping("/airline1/{airline}")
    public ResponseEntity<Optional<FlightDto>> getAirline(@PathVariable String airline){
        Optional<FlightDto> flightDtos4=flightService.getByAirline(airline);
        return ResponseEntity.ok(flightDtos4);
    }

    @GetMapping("/search/{source}/{destination}")
    public ResponseEntity<List<FlightDto>> searchFlights(
            @PathVariable String source,
            @PathVariable String destination) {

        List<FlightDto> flights = flightService.searchFlightNative(source, destination);
        return ResponseEntity.ok(flights);
    }




}
