package com.starlight.stockmoex.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StockService {

    @Autowired
    StockMoex stockDetail

    String getStockFromMoex() {
        def detail = stockDetail.getStockFromMoex()
        println detail
        return detail
    }


}
