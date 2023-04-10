package com.starlight.cryptoexmo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.starlight.cryptoexmo.model.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CryptoService {

    private final CryptoExmo cryptoExmo;

    public String getAllCoinsFromExmoExchange() {


        List<Currency> telegramDataDtos = JSON.parseArray(cryptoExmo.getCoinsFromExmo(), Currency.class);
        System.out.println();
        System.out.println(telegramDataDtos.size());


//        JSONObject object = JSON.parseObject(s);
//        Object jsonArray = object.get("js");
//        System.out.println(jsonArray);
//        List<Weibo> list = JSON.parseArray(jsonArray+"", Weibo.class);
//        for (Weibo weibo : list) {
//            System.out.println(weibo.getCity());


            return null;
    }


}
