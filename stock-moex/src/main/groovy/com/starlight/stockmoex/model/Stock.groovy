package com.starlight.stockmoex.model

import groovy.transform.ToString
import groovy.transform.builder.Builder

@Builder
@ToString
class Stock {

    String id
    String boardid
    Double price
    String name
    String date
}
