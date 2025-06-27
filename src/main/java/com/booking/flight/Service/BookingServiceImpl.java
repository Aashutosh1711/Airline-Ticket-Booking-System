package com.booking.flight.Service;

import com.booking.flight.Dto.BookingDto;
import com.booking.flight.Repository.BookingRepo;
import com.booking.flight.Service.Serviceinterface.BookingService;
import com.booking.flight.entity.Booking;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
    private BookingRepo bookingRepo;
    private ModelMapper modelMapper;

    public BookingServiceImpl(BookingRepo bookingRepo,ModelMapper modelMapper){
        this.bookingRepo=bookingRepo;
        this.modelMapper=modelMapper;
    }



    @Override
    public BookingDto bookFlight(BookingDto bookingDto) {
        Booking book=modelMapper.map(bookingDto,Booking.class);
        Booking saveEntity=bookingRepo.save(book);
        return modelMapper.map(saveEntity,BookingDto.class);
    }

    @Override
    public Optional<BookingDto> getById( Long id) {
        return bookingRepo.findById(id)
                .map(booking->modelMapper.map(booking,BookingDto.class));
    }



    @Override
    public Page<BookingDto> getAll(Pageable pageable) {
        return bookingRepo.findAll(pageable)
                .map(booking->modelMapper.map(booking,BookingDto.class));
    }

    @Override
    public BookingDto cancelFlight(Long id) {

        Booking booking= bookingRepo.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
        bookingRepo.delete(booking);
        return modelMapper.map(booking,BookingDto.class);
    }
}
