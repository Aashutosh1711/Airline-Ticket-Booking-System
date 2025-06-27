package com.booking.flight.Controller;

import com.booking.flight.Dto.PassengerDto;
import com.booking.flight.Dto.PaymentDto;
import com.booking.flight.Service.PaymentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/air-line/payment")
public class PaymentController {

    private PaymentServiceImpl paymentService;


    public PaymentController(PaymentServiceImpl paymentService){
        this.paymentService=paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<PaymentDto> paymentInitiate(@RequestBody PaymentDto paymentDto){
        PaymentDto paymentDto1=paymentService.initiatePayment(paymentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentDto1);
    }


    @GetMapping("/{id}")
    public ResponseEntity<PaymentDto> getPaymentById(@PathVariable Long id){
        PaymentDto paymentDto= paymentService.getPaymentById(id);
        return ResponseEntity.ok(paymentDto);
    }



}
