package com.booking.flight.Service.Serviceinterface;

import com.booking.flight.Dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDto saveUser(UserDto userDto);
    UserDto updateUser(UserDto userDto,Long id);
    Optional<UserDto> findById(Long id);
    List<UserDto> getAll();
    Optional<UserDto> findByName(String name);
    UserDto delete(Long id);

}
