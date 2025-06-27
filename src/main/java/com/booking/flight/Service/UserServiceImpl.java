package com.booking.flight.Service;

import com.booking.flight.Dto.UserDto;
import com.booking.flight.Repository.UserRepository;
import com.booking.flight.Service.Serviceinterface.UserService;
import com.booking.flight.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        User user=convertUserDtotoUser(userDto);
        User saveEntity=userRepository.save(user);
        return convertUsertoUserDto(saveEntity);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long id) {
        User user=userRepository.findById(id).orElseThrow(()->new RuntimeException("No User is available to Update"));
        user.setFullname(userDto.getFullname());
        user.setEmail(userDto.getEmail());
        user.setMobileNumber(userDto.getMobileNumber());
        user.setGender(userDto.getGender());
        user.setAge(userDto.getAge());

        User saveEntity1=userRepository.save(user);
        return convertUsertoUserDto(saveEntity1);
    }

    @Override
    public Optional<UserDto> findById(Long id) {
       return userRepository.findById(id).map(this::convertUsertoUserDto);
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users=userRepository.findAll();
        List<UserDto> userDtos=users.stream().map(is->convertUsertoUserDto(is)).toList();
        return userDtos;
    }

    @Override
    public Optional<UserDto> findByName(String name) {
        return userRepository.findByFullname(name).map(this::convertUsertoUserDto);

    }

    @Override
    public UserDto delete( Long id) {
       User user=userRepository.findById(id).orElseThrow(()->new RuntimeException("No id is there to Delete"));
       UserDto userDto=convertUsertoUserDto(user);
       userRepository.deleteById(id);
       return userDto;

    }
    public UserDto convertUsertoUserDto(User user){
        UserDto userDto=new UserDto();
       userDto.setId(user.getId());
       userDto.setFullname(user.getFullname());
       userDto.setEmail(user.getEmail());
       userDto.setMobileNumber(user.getMobileNumber());
       userDto.setGender(user.getGender());
       userDto.setAge(user.getAge());
       userDto.setPassenger(user.getPassenger());
       return userDto;
    }

    public User convertUserDtotoUser(UserDto userDto){
        User user=new User();
        user.setId(userDto.getId());
        user.setFullname(userDto.getFullname());
        user.setEmail(userDto.getEmail());
        user.setMobileNumber(userDto.getMobileNumber());
        user.setGender(userDto.getGender());
        user.setAge(userDto.getAge());
        user.setPassenger(userDto.getPassenger());


        return user;
    }
}
