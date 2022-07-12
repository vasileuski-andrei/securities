package com.starlight.stockmoex

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class StockMoexApplication {

    static void main(String[] args) {
        SpringApplication.run(StockMoexApplication, args)
    }

}
