package com.booking.flight.Service;

import com.booking.flight.Dto.FlightDto;
import com.booking.flight.Repository.FlightRepo;
import com.booking.flight.Service.Serviceinterface.FlightService;
import com.booking.flight.entity.Flight;
import jakarta.persistence.Table;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@Service
@Transactional
public class FlightServiceImpl implements FlightService {

    private FlightRepo flightRepo;
    private ModelMapper modelMapper;


    public FlightServiceImpl(FlightRepo flightRepo,ModelMapper modelMapper){
        this.flightRepo=flightRepo;
        this.modelMapper=modelMapper;
    }




    @Override
    public FlightDto addFlight(FlightDto flightDto) {
        Flight flight=modelMapper.map(flightDto,Flight.class);
        Flight saveEntity=flightRepo.save(flight);
        return modelMapper.map(saveEntity,FlightDto.class);
    }

    @Override
    public FlightDto UpdateFlight(FlightDto flightDto,Long id) {
        Flight flight=flightRepo.findById(id).orElseThrow(()-> new RuntimeException("Yet Not Found"));
        flight.setId(flightDto.getId());
        flight.setFlightname(flightDto.getFlightname());
        flight.setAirline(flightDto.getAirline());
        flight.setSource(flightDto.getSource());
        flight.setDestination(flightDto.getDestination());
        flight.setDepartureTime(flightDto.getDepartureTime());
        flight.setArrivalTime(flightDto.getArrivalTime());
        Flight save=flightRepo.save(flight);
        return modelMapper.map(save,FlightDto.class);
    }

    @Override
    public Optional<FlightDto> getByName(String flightname) {
        return flightRepo.findByFlightname(flightname)
                .map(flight -> modelMapper.map(flight,FlightDto.class));
    }



    @Override
    public Optional<FlightDto> getByAirline(String airline) {
        return flightRepo.getByAirline(airline).map(flight -> modelMapper
                .map(flight,FlightDto.class));
    }

    @Override
    public List<FlightDto> searchFlightNative(String source, String destination) {
        return flightRepo.searchFlightsNative(source,destination).stream()
                .map(flight -> flight.getSource()
                        .equalsIgnoreCase(source) && flight.getSource()
                        .equalsIgnoreCase(destination))
                .map(flight->modelMapper.map(flight,FlightDto.class))
                .collect(Collectors.toList());
    }
//@Override
//public List<FlightDto> searchFlightNative(String source, String destination) {
//    return flightRepo.searchFlightsNative(source, destination).stream()
//            .filter(flight -> flight.getSource().equalsIgnoreCase(source)
//                    && flight.getDestination().equalsIgnoreCase(destination))
//            .map(flight -> modelMapper.map(flight, FlightDto.class))
//            .collect(Collectors.toList());
//}

}
