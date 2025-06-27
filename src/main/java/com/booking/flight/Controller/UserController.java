package com.booking.flight.Controller;

import com.booking.flight.Dto.UserDto;
import com.booking.flight.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/air-line/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;


    @PostMapping
    private ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto){
        UserDto userDto1=userService.saveUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto1);
    }

    @PutMapping("/update/something")
    private ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @RequestParam Long id){
        UserDto userDto1=userService.updateUser(userDto,id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userDto1);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Optional<UserDto>> getByid(@PathVariable Long id){
        Optional<UserDto> userDto=userService.findById(id);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/findAll")
    private ResponseEntity<List<?>> getAll(){
        List<UserDto> userDtos=userService.getAll();
        return ResponseEntity.ok(userDtos);
    }

    @RequestMapping(value = "/getName/{name}", method = RequestMethod.GET)
    private ResponseEntity<Optional<UserDto>> getName(@PathVariable String name){
        Optional<UserDto> userDto=userService.findByName(name);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<UserDto> deleteAll(@PathVariable Long id){
        UserDto userDto=userService.delete(id);
        return ResponseEntity.ok(userDto);
    }


}
