package com.starlight.stockmoex.service

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name = "stockmoex", url = '${moex.stock.url}')
interface StockMoex {

    @GetMapping
    String getStockFromMoex()

}