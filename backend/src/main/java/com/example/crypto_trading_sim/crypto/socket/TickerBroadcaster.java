package com.example.crypto_trading_sim.crypto.socket;

import com.example.crypto_trading_sim.crypto.data.TickerData;
import com.example.crypto_trading_sim.crypto.data.TickerDataStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

public class TickerBroadcaster {
    private final TickerDataStorage tickerDataStorage;
    private final SimpMessagingTemplate messageTemplate;

    @Autowired
    public TickerBroadcaster(TickerDataStorage tickerDataStorage, SimpMessagingTemplate messageTemplate) {
        this.tickerDataStorage = tickerDataStorage;
        this.messageTemplate = messageTemplate;
    }

    @Scheduled(fixedRate = 1000)
    public void pushTickerUpdates() {
        List<TickerData> topSymbols = tickerDataStorage.getTopSymbols(20);
        messageTemplate.convertAndSend("/topic/ticker", topSymbols);
    }
}
