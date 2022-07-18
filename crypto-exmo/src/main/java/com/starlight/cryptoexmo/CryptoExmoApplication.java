package com.starlight.cryptoexmo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CryptoExmoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CryptoExmoApplication.class, args);
    }

}
