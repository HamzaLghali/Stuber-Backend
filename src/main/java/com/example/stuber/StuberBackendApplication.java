package com.example.stuber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.example.stuber.repository")
public class StuberBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(StuberBackendApplication.class, args);
	}

}
