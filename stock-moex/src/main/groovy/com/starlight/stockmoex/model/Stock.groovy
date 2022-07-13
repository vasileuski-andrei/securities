package com.starlight.stockmoex.model

import groovy.transform.ToString
import groovy.transform.builder.Builder

@Builder
@ToString
class Stock {

    String id
    String boardid
    String date
    String updateTime
    Double open
    Double low
    Double high
    Double last
}
