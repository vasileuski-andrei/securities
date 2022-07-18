package com.starlight.cryptoexmo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "crypto-exmo", url = "${exmo.crypto.url}")
interface CryptoExmo {

    @GetMapping
    String getCoinsFromExmo();

}