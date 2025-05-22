package com.example.crypto_trading_sim.crypto.api.enums;

public enum CryptoApiEventTriggerEnum {
    BEST_BID_OFFER("bbo"),
    ON_EVERY_TRADE("trades");

    private final String value;

    CryptoApiEventTriggerEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
