package com.starlight.stockmoex.parser

import com.starlight.stockmoex.model.Stock

interface Parser {
    List<Stock> parse(String stock)

}