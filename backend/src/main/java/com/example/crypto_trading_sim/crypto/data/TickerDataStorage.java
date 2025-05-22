package com.example.crypto_trading_sim.crypto.data;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
public class TickerDataStorage {
    private final ConcurrentHashMap<String, TickerData> tickerLastData = new ConcurrentHashMap<>();

    public void updateTicker(String ticker, TickerData data) {
        tickerLastData.put(ticker, data);
    }

    public List<TickerData> getTopSymbols(int count) {
        return tickerLastData.values().stream()
                .limit(count)
                .collect(Collectors.toList());
    }
}
