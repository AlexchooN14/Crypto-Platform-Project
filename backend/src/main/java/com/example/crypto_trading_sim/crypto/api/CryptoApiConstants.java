package com.example.crypto_trading_sim.crypto.api;

import com.example.crypto_trading_sim.crypto.api.enums.CryptoApiChannelsEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CryptoApiConstants {
    @Value("${crypto.api.base-url}")
    public String BASE_URL;

    public String getFullUrl(CryptoApiChannelsEnum channel) {
        return BASE_URL + "/" + channel.getValue();
    }
}

