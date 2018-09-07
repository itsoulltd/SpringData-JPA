package com.itsoul.lab.jpa.app;

import com.itsoul.lab.jpa.entites.Passenger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.itsoul.lab.jpa.app"
		,"com.itsoul.lab.jpa.controllers"})
@EnableJpaRepositories("com.itsoul.lab.jpa.repository")
@EntityScan(basePackageClasses = Passenger.class)
public class JpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}
}
