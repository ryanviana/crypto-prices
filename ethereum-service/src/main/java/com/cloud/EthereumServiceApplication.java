package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication()
public class EthereumServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EthereumServiceApplication.class, args);
    }
}
