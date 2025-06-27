package com.booking.flight.Controller;

import com.booking.flight.Dto.FlightDto;
import com.booking.flight.Dto.UserDto;
import com.booking.flight.Service.AdminServiceImpl;
import com.booking.flight.Service.FlightServiceImpl;
import com.booking.flight.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/air-flight/admin")
public class AdminController {

    private final AdminServiceImpl adminService;
    private final FlightServiceImpl flightService;
    public AdminController(AdminServiceImpl adminService,FlightServiceImpl flightService){
        this.adminService=adminService;
        this.flightService=flightService;
    }

    @PostMapping("/add/admin")
    public ResponseEntity<FlightDto> addfli(@RequestBody FlightDto flightDto){
        FlightDto flightDto1=adminService.addFlight(flightDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(flightDto1);
    }

    @PutMapping("update/admin")
    public ResponseEntity<FlightDto> upFlight(@RequestParam Long id,@RequestBody FlightDto flightDto){
        FlightDto flightDto1=adminService.updateFlight(id,flightDto);
        return ResponseEntity.ok(flightDto);
    }

    @DeleteMapping("delete/admin/{id}")
    public ResponseEntity<Void> delFlight(@PathVariable Long id){
        adminService.deleteFlight(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("getAll/admin")
    public ResponseEntity<List<FlightDto>> getFli(@RequestParam String flightname){
       List<FlightDto> flightDto=adminService.getAllFlights(flightname);
       return ResponseEntity.ok(flightDto);
    }

    @GetMapping("getAll-user/admin")
    public ResponseEntity<Optional<UserDto>> getFliUser(@RequestBody UserDto userDto, @RequestParam String email){
        Optional<UserDto> userDto1=adminService.getAllUsers(userDto,email);
        return ResponseEntity.ok(userDto1);

    }


}
