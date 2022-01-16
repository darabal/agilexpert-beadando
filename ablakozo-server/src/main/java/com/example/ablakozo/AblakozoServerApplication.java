package com.example.ablakozo;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ablakozo.model.User;
import com.example.ablakozo.repo.UserRepo;

@SpringBootApplication
public class AblakozoServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AblakozoServerApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(UserRepo userRepo) {
		return args -> {
			User u = new User(null,"Admin",null);
			userRepo.save(u);
			
			
		};
	}
	

}
