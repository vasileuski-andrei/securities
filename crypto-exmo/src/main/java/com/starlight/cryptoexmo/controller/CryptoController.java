package com.starlight.cryptoexmo.controller;

import com.starlight.cryptoexmo.service.CryptoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CryptoController {

    private final CryptoService cryptoService;

    @GetMapping("/coins")
    public String getAllCoins() {
        return cryptoService.getAllCoinsFromExmoExchange();

    }
}
