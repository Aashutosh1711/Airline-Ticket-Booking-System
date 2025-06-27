package com.booking.flight;

import com.booking.flight.Repository.AdminRepo;
import com.booking.flight.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirlineTicketBookingSystemApplication implements CommandLineRunner {

	@Autowired
	private AdminRepo adminRepo;

	public static void main(String[] args) {
		SpringApplication.run(AirlineTicketBookingSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String username = "flightManager";

		if (adminRepo.findByUsername(username).isEmpty()) {
			Admin a1 = new Admin();
			a1.setUsername(username);
			a1.setPassword("flight@123");
			adminRepo.save(a1);
			System.out.println("Admin created.");
		} else {
			System.out.println("Admin already exists.");
		}
	}

}
