package com.booking.flight.Controller;

import com.booking.flight.Dto.PassengerDto;
import com.booking.flight.Service.PassengerServiceImpl;
import com.booking.flight.Service.Serviceinterface.PassengerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/air-line/passenger")
public class PassengerController {

    private PassengerServiceImpl passengerService;

    public PassengerController(PassengerServiceImpl passengerService){
        this.passengerService=passengerService;
    }


    @RequestMapping(method = RequestMethod.POST,value = "/add-passenger")
    public ResponseEntity<PassengerDto> addPassenger(@RequestBody PassengerDto passengerDto){
        PassengerDto passengerDto1=passengerService.addPassenger(passengerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(passengerDto1);

    }

    @PutMapping("/update/passenger")
    public ResponseEntity<PassengerDto> updatePassenger(@RequestBody PassengerDto passengerDto,@RequestParam Long id){
        PassengerDto passengerDto2=passengerService.updatePassenger(passengerDto,id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(passengerDto2);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PassengerDto> dltPassenger(@PathVariable Long id){
        PassengerDto passengerDto3=passengerService.deletePassenger(id);
        return ResponseEntity.ok(passengerDto3);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Optional<PassengerDto>> getByName(@PathVariable String name){
        Optional<PassengerDto> passengerDto4=passengerService.getPassenger(name);
        return ResponseEntity.ok(passengerDto4);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<List<PassengerDto>> getPassengerId(@PathVariable Long id){
        List<PassengerDto> passengerDtos=passengerService.getPassengersByUserId(id);
        return ResponseEntity.ok(passengerDtos);
    }

}
