package com.booking.flight.Service;

import com.booking.flight.Dto.BookingDto;
import com.booking.flight.Dto.FlightDto;
import com.booking.flight.Dto.UserDto;
import com.booking.flight.Repository.BookingRepo;
import com.booking.flight.Repository.FlightRepo;
import com.booking.flight.Repository.UserRepository;
import com.booking.flight.Service.Serviceinterface.AdminService;
import com.booking.flight.entity.Flight;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    private FlightRepo flightRepo;
    private UserRepository userRepository;
    private BookingRepo bookingRepo;
    private ModelMapper modelMapper;

    public AdminServiceImpl(FlightRepo flightRepo,UserRepository userRepository,BookingRepo bookingRepo,ModelMapper modelMapper){
        this.flightRepo=flightRepo;
        this.userRepository=userRepository;
        this.bookingRepo=bookingRepo;
        this.modelMapper=modelMapper;
    }

    @Override
    public FlightDto addFlight(FlightDto flightDto) {
       Flight flight=modelMapper.map(flightDto,Flight.class);
       Flight saveEntity=flightRepo.save(flight);
       return modelMapper.map(saveEntity,FlightDto.class);
    }

    @Override
    public FlightDto updateFlight(Long flightId, FlightDto flightDto) {
        Flight flight=flightRepo.findById(flightId)
                .orElseThrow(()-> new RuntimeException("Not Found"));
        flight.setId(flightDto.getId());
        flight.setFlightname(flightDto.getFlightname());
        flight.setAirline(flightDto.getAirline());
        flight.setSource(flightDto.getSource());
        flight.setDestination(flight.getDestination());
        flight.setDepartureTime(flightDto.getDepartureTime());
        flight.setArrivalTime(flightDto.getArrivalTime());
        flight.setTotalseat(flightDto.getTotalseat());
        flight.setAvailableSeat(flightDto.getAvailableSeat());
        Flight saveEntity=flightRepo.save(flight);
        return modelMapper.map(saveEntity,FlightDto.class);

    }

    @Override
    public void deleteFlight(Long flightId) {
        Flight flight=flightRepo.findById(flightId).orElseThrow(()->new NoSuchElementException("Not Found"));
        flightRepo.delete(flight);

    }

    @Override
    public List<FlightDto> getAllFlights(String flightname) {
        return flightRepo.findByFlightname(flightname).stream()
                .map(flight -> modelMapper.map(flight,FlightDto.class)).toList();
    }



    @Override
    public Optional<UserDto> getAllUsers(UserDto userDto, String email) {
        return userRepository.findByEmail(email)
                .map(emails->modelMapper.map(emails,UserDto.class));
    }
//Do it Later
    @Override
    public double getTotalRevenue() {
        return 0;
    }
}
