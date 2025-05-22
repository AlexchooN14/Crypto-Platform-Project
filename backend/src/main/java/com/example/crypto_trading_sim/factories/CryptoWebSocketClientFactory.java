package com.example.crypto_trading_sim.factories;

import com.example.crypto_trading_sim.crypto.api.CryptoApiConstants;
import com.example.crypto_trading_sim.crypto.api.CryptoApiSocketClient;
import com.example.crypto_trading_sim.crypto.data.TickerDataStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class CryptoWebSocketClientFactory {

    private final TickerDataStorage tickerDataStorage;

    @Autowired
    public CryptoWebSocketClientFactory(TickerDataStorage tickerDataStorage) {
        this.tickerDataStorage = tickerDataStorage;
    }

    public CryptoApiSocketClient createClient() throws URISyntaxException {
        URI uri = new URI(CryptoApiConstants.BASE_URL);
        return new CryptoApiSocketClient(uri, tickerDataStorage);
    }
}

