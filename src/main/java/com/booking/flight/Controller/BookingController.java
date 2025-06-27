package com.booking.flight.Controller;

import com.booking.flight.Dto.BookingDto;
import com.booking.flight.Dto.FlightDto;
import com.booking.flight.Service.BookingServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/air-line/booking")
public class BookingController {

    private BookingServiceImpl bookingService;

    public BookingController(BookingServiceImpl bookingService){
        this.bookingService=bookingService;
    }
    @PostMapping("/give-booking")
    public ResponseEntity<BookingDto> bookFlight(@RequestBody BookingDto bookingDto){
        BookingDto bookingDto1=bookingService.bookFlight(bookingDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingDto1);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<BookingDto>> getid(@PathVariable Long id){
        Optional<BookingDto> bookingDto3=bookingService.getById(id);
        return ResponseEntity.ok(bookingDto3);
    }
//    @GetMapping("/{page}")
//    public ResponseEntity<Page<BookingDto>> giveAll(@PathVariable Pageable pageable){
//        Page<BookingDto> bookingDtos4=bookingService.getAll(pageable);
//        return ResponseEntity.ok(bookingDtos4);
//    }
//    @GetMapping("/all")
//    public ResponseEntity<Page<BookingDto>> giveAll(Pageable pageable) {
//        Page<BookingDto> bookingDtos4 = bookingService.getAll(pageable);
//        return ResponseEntity.ok(bookingDtos4);
//    }
@GetMapping("/all")
public ResponseEntity<Page<BookingDto>> giveAll(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "id") String sortBy
) {
    Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
    Page<BookingDto> bookingDtos = bookingService.getAll(pageable);
    return ResponseEntity.ok(bookingDtos);
}

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteflight(@PathVariable Long id){
        BookingDto bookingDto5=bookingService.cancelFlight(id);
        return ResponseEntity.ok(bookingDto5);

    }


}
