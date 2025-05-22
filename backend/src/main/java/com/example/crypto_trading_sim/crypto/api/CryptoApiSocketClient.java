package com.example.crypto_trading_sim.crypto.api;
import com.example.crypto_trading_sim.crypto.api.SubscribeRequest;
import com.example.crypto_trading_sim.crypto.api.SubscribeRequestProvider;
import com.example.crypto_trading_sim.crypto.api.enums.CryptoApiEventTriggerEnum;
import com.example.crypto_trading_sim.crypto.data.TickerData;
import com.example.crypto_trading_sim.crypto.data.TickerDataStorage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;

public class CryptoApiSocketClient extends WebSocketClient {

    private final TickerDataStorage tickerDataStorage;

    public CryptoApiSocketClient(URI serverUri, TickerDataStorage tickerDataStorage) {
        super(serverUri);
        this.tickerDataStorage = tickerDataStorage;
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        System.out.println("Connected to WebSocket");

        SubscribeRequest subscribeRequest = SubscribeRequestProvider.subscribeTicker(
            Arrays.asList("BTC/USD"),
            CryptoApiEventTriggerEnum.ON_EVERY_TRADE,
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
        try {
            JSONArray dataArray = new JSONObject(message).getJSONArray("data");

            for (int i = 0; i < dataArray.length(); i++) {
                JSONObject dataForTicker = dataArray.getJSONObject(i);
                String symbol = dataForTicker.getString("symbol");
                double bid = dataForTicker.getDouble("bid");
                double ask = dataForTicker.getDouble("ask");

                TickerData newTickerData = new TickerData(symbol, bid);
                tickerDataStorage.updateTicker(symbol, newTickerData);
            }

        } catch (Exception e) {
            System.err.println("Failed to parse message: " + message);
        }
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