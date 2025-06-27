package com.booking.flight.Service;

import com.booking.flight.Dto.PassengerDto;
import com.booking.flight.Repository.PassengerRepo;
import com.booking.flight.Repository.UserRepository;
import com.booking.flight.Service.Serviceinterface.PassengerService;
import com.booking.flight.entity.Passenger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    private PassengerRepo passengerRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;


    @Override
    public PassengerDto addPassenger(PassengerDto passengerDto) {
        Passenger passenger = modelMapper.map(passengerDto, Passenger.class);
        // ✅ Step 1: Fetch the user by ID from the DTO
        Long userId = passengerDto.getUser().getId();
        var user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
        // ✅ Step 2: Set user → passenger and passenger → user
        passenger.setUser(user);        // For setting user_id in passenger table
        user.setPassenger(passenger);  // For setting passenger_id in user table
        // ✅ Step 3: Save passenger (user will be updated automatically if CascadeType.ALL is set)
        Passenger savedPassenger = passengerRepo.save(passenger);
        return modelMapper.map(savedPassenger, PassengerDto.class);
    }


//    @Override
//    public PassengerDto addPassenger(PassengerDto passengerDto) {
//        Passenger passenger=modelMapper.map(passengerDto,Passenger.class);
//        Passenger saveEntity=passengerRepo.save(passenger);
//        return modelMapper.map(saveEntity,PassengerDto.class);
//
//    }

    @Override
    public PassengerDto updatePassenger(PassengerDto passengerDto, Long id) {
        Passenger passenger=passengerRepo.findById(id).orElseThrow(()-> new RuntimeException("Passenger Not Found"));
        passenger.setId(passengerDto.getId());
        passenger.setName(passengerDto.getName());
        passenger.setAge(passengerDto.getAge());
        passenger.setGender(passengerDto.getGender());
        Passenger saveEntity=passengerRepo.save(passenger);
        return modelMapper.map(saveEntity,PassengerDto.class);

    }

    @Override
    public PassengerDto deletePassenger(Long id) {
        Passenger passenger=passengerRepo.findById(id).orElseThrow(()-> new RuntimeException("Id is Not Present"));
        passengerRepo.delete(passenger);
        return null;
    }

    @Override
    public Optional<PassengerDto> getPassenger(String name) {
        return passengerRepo.findByName(name)
                .map(passenger -> modelMapper.map(passenger,PassengerDto.class));
    }

    @Override
    public List<PassengerDto> getPassengersByUserId(Long userId) {
        List<Passenger>passengers=passengerRepo.findPassengerByUserId(userId);
        if(passengers==null){
            throw new RuntimeException("No Such Id is Present"+userId);
        }

        return passengers.stream()
                .map(passenger -> modelMapper.map(passenger,PassengerDto.class))
                .toList();
    }
}
