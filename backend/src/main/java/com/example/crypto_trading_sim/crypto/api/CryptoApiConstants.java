package com.example.crypto_trading_sim.crypto.api;

import com.example.crypto_trading_sim.crypto.api.enums.CryptoApiChannelsEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class CryptoApiConstants {
    public static final String BASE_URL = "wss://ws.kraken.com/v2";

    public String getFullUrl(CryptoApiChannelsEnum channel) {
        return BASE_URL + "/" + channel.getValue();
    }
}

