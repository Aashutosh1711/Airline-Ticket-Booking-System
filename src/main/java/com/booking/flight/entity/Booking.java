package com.booking.flight.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate bookingDate;



    private int totalSeat;
    @ManyToOne
    @JoinColumn(name = "passenger_id", referencedColumnName = "id")
    private Passenger passenger;

    @ManyToOne
    @JoinColumn(name = "flight_id", referencedColumnName = "id")
    private Flight flight;
    public Booking() {

    }

    public Booking(LocalDate bookingDate, int totalSeat, Passenger passenger, Flight flight) {
        this.bookingDate = bookingDate;
        this.totalSeat = totalSeat;
        this.passenger = passenger;
        this.flight = flight;
    }


    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }

//    public String getUser(){
//        return user;
//    }
//    public void setUser(String user){
//        this.user=user;
//    }



    public LocalDate getBookingDate(){
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate){
        this.bookingDate=bookingDate;
    }


    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }
}
