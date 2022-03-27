package com.p1demo.driver;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.p1demo.model.Request;
import com.p1demo.model.Request.Type;
import com.p1demo.repo.RequestRepo;

@SpringBootApplication
public class SbDemoP1Application {

	public static void main(String[] args) {
		SpringApplication.run(SbDemoP1Application.class, args);
	}
	
	
	CommandLineRunner runTest(RequestRepo reqRepo) {
		return args ->{
			reqRepo.save(new Request(Type.FOOD, 432.23, 101, LocalDateTime.now()));
		};
	}


}
