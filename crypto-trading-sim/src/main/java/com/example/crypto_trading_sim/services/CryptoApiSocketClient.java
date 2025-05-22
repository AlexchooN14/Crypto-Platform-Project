package com.example.crypto_trading_sim.services;
import com.example.crypto_trading_sim.crypto.api.SubscribeRequest;
import com.example.crypto_trading_sim.crypto.api.SubscribeRequestProvider;
import com.example.crypto_trading_sim.crypto.api.enums.CryptoApiEventTriggerEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;

public class CryptoApiSocketClient extends WebSocketClient {

    public CryptoApiSocketClient(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        System.out.println("Connected to WebSocket");

        SubscribeRequest subscribeRequest = SubscribeRequestProvider.subscribeTicker(
            Arrays.asList("BTC/USD", "MATIC/GBP"),
            CryptoApiEventTriggerEnum.BEST_BID_OFFER,
            true
        );

        String subscribeJson = null;
        try {
            subscribeJson = new ObjectMapper().writeValueAsString(subscribeRequest);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        send(subscribeJson);
    }

    @Override
    public void onMessage(String message) {
        System.out.println("Received: " + message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("Connection closed: " + reason);
    }

    @Override
    public void onError(Exception ex) {
        ex.printStackTrace();
    }
}