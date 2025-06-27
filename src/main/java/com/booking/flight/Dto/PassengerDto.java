package com.booking.flight.Dto;

import com.booking.flight.entity.Booking;
import com.booking.flight.entity.User;
import jakarta.persistence.Column;

import java.util.List;

public class PassengerDto {

    private Long id;
    private String name;
    private String age;
    private String gender;

    private User user;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
