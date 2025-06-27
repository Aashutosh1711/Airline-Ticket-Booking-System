package com.booking.flight.Service.Serviceinterface;

import com.booking.flight.Dto.PaymentDto;

import java.util.List;

public interface PaymentService {
    PaymentDto initiatePayment(PaymentDto paymentDto);
//    PaymentDto confirmPayment(Long transactionId);
    PaymentDto getPaymentById(Long id);
//    List<PaymentDto> getPaymentByUserId(Long userId);








}
