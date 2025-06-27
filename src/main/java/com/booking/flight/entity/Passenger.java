package com.booking.flight.entity;

import jakarta.persistence.*;

import java.awt.print.Book;
import java.util.List;

@Entity
@Table(name="passenger")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(nullable = false)
    private String age;
    private String gender;
    @OneToMany(mappedBy = "passenger")
    private List<Booking> booking;

//    @OneToOne(mappedBy = "passenger")
//    private User user;
    @OneToOne
    @JoinColumn(name = "user_id") // foreign key in Passenger table
    private User user;



    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }

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
