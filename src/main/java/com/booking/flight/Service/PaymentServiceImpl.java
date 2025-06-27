package com.booking.flight.Service;

import com.booking.flight.Dto.PaymentDto;
import com.booking.flight.Repository.PaymentRepo;
import com.booking.flight.Repository.UserRepository;
import com.booking.flight.Service.Serviceinterface.PaymentService;
import com.booking.flight.entity.Payment;
import com.booking.flight.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepo paymentRepo;
    @Autowired
    private UserRepository userRepository;
    @Override
    public PaymentDto initiatePayment(PaymentDto paymentDto) {
        Payment payment = convertPaymentDtotoPayment(paymentDto);

        // Save the payment entity to the database
        Payment savedPayment = paymentRepo.save(payment);

        // Convert saved entity back to DTO
        return convertPaymenttoPaymentDto(savedPayment);
    }

//    @Override
//    public PaymentDto confirmPayment(Long transactionId) {
//        Payment payment = paymentRepo.findByTransactionId(transactionId).orElseThrow(() -> new RuntimeException("Payment Not Found Exception"));
//
//        payment.setStatus("Confirm");
//        Payment updatePay=paymentRepo.save(payment);
//        return convertPaymenttoPaymentDto(updatePay);
//
//    }

    @Override
    public PaymentDto getPaymentById(Long id) {
        Payment payment= paymentRepo.findById(id).orElseThrow(() -> new RuntimeException("No Such Id Exists"));
        return convertPaymenttoPaymentDto(payment);

    }

//    @Override
//    public List<PaymentDto> getPaymentByUserId(Long userId) {
//        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Not Present"));
//        List<Payment> payments = paymentRepo.findByUserId(userId);
//        return payments.stream().map(this::convertPaymenttoPaymentDto).collect(Collectors.toList());
//    }
//   convert --->Payment from PaymentDto
    public PaymentDto convertPaymenttoPaymentDto(Payment payment){
        PaymentDto paymentDto=new PaymentDto();
        paymentDto.setId(payment.getId());
        paymentDto.setAmount(payment.getAmount());
        paymentDto.setPaymentMethod(payment.getPaymentMethod());
        paymentDto.setStatus(payment.getStatus());
        paymentDto.setPaymentDate(payment.getPaymentDate());
        paymentDto.setBooking(payment.getBooking());
        return paymentDto;
    }
//    convert ---->PaymentDto to Payment
    public Payment convertPaymentDtotoPayment(PaymentDto paymentDto){
        Payment payment=new Payment();
        payment.setId(paymentDto.getId());
        payment.setAmount(paymentDto.getAmount());
        payment.setPaymentMethod(paymentDto.getPaymentMethod());
        payment.setStatus(paymentDto.getStatus());
        payment.setPaymentDate(paymentDto.getPaymentDate());
        payment.setBooking(paymentDto.getBooking());
        return payment;
    }






}
