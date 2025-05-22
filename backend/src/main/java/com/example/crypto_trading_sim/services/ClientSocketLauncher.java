package com.example.crypto_trading_sim.services;

import com.example.crypto_trading_sim.crypto.api.CryptoApiSocketClient;
import com.example.crypto_trading_sim.factories.CryptoWebSocketClientFactory;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientSocketLauncher {

    private final CryptoWebSocketClientFactory clientFactory;

    @Autowired
    public ClientSocketLauncher(CryptoWebSocketClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    @PostConstruct
    public void connect() {
        try {
            CryptoApiSocketClient client = clientFactory.createClient();
            client.connectBlocking();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

