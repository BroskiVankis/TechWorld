package com.example.techworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TechworldApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechworldApplication.class, args);
    }

}
