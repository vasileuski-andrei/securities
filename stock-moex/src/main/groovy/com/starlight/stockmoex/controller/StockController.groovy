package com.starlight.stockmoex.controller

import com.starlight.stockmoex.service.StockService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StockController {

    @Autowired
    StockService stockService;

    @GetMapping("/stock")
    String getStock() {
        return stockService.getStockFromMoex()
    }
}
