package com.example.crypto_trading_sim.crypto.api.enums;

public enum CryptoApiChannelsEnum {
    TICKER_CHANNEL("ticker"),
    BOOK_CHANNEL("book"),
    OHLC_CHANNEL("ohlc");

    private final String value;

    CryptoApiChannelsEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
