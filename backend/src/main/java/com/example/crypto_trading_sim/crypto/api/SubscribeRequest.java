package com.example.crypto_trading_sim.crypto.api;

public class SubscribeRequest {
    private final String method = "subscribe";
    private Object params;

    public SubscribeRequest(Object params) {
        this.params = params;
    }

    public String getMethod() {
        return method;
    }

    public Object getParams() {
        return params;
    }
}
