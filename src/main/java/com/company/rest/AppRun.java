package com.company.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppRun {
    /* Start of the Application */
    public static void main(String[] args) {
        SpringApplication.run(AppRun.class, args);
    }
}

