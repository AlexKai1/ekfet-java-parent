package com.ekfet.boothystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class BootHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootHystrixApplication.class, args);
    }

}
