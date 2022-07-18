package com.starlight.cryptoexmo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Currency {

    private String buyPrice;
    private String sellPrice;
    private String lastTrade;
    private String high;
    private String low;
    private String avg;
    private String volume;
    private String updated;

}
