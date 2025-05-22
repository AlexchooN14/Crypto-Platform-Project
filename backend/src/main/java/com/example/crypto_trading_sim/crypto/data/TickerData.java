package com.example.crypto_trading_sim.crypto.data;

public class TickerData {
    private String symbol;
    private double price;

    public TickerData(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }
}

