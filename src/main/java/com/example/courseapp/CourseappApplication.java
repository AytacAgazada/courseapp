package com.example.courseapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.courseapp")
public class CourseappApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseappApplication.class, args);
    }

}
