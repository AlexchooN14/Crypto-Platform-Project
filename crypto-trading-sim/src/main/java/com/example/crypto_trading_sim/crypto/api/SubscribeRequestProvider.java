package com.example.crypto_trading_sim.crypto.api;

import com.example.crypto_trading_sim.crypto.api.enums.CryptoApiEventTriggerEnum;
import com.example.crypto_trading_sim.crypto.api.parameters.TickerParameters;

import java.util.List;

public class SubscribeRequestProvider {

    public static SubscribeRequest subscribeTicker(List<String> symbols, CryptoApiEventTriggerEnum eventTrigger, Boolean snapshot) {
        TickerParameters params = new TickerParameters(symbols, eventTrigger, snapshot);
        return new SubscribeRequest(params);
    }

    // Place for other potential SubscribeRequests

}

