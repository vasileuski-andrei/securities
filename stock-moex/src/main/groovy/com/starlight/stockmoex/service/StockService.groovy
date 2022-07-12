package com.starlight.stockmoex.service

import com.starlight.stockmoex.model.Stock
import com.starlight.stockmoex.parser.Parser
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Slf4j
@Service
class StockService {

    @Autowired
    StockMoex stockDetail

    @Autowired
    Parser parser

    List<Stock> getStockFromMoex() {
        def stockXml = stockDetail.getStockFromMoex()
        log.info("Get stock from Moex")
        def listStockDto = parser.parse(stockXml)

        if (listStockDto.isEmpty()) {
            log.error("List of stock dto is empty. Probably Moex didn't response correctly")
        }

        return listStockDto
    }


}
