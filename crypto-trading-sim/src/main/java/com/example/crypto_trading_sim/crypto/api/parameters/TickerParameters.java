package com.example.crypto_trading_sim.crypto.api.parameters;

import com.example.crypto_trading_sim.crypto.api.enums.CryptoApiChannelsEnum;
import com.example.crypto_trading_sim.crypto.api.enums.CryptoApiEventTriggerEnum;

import java.util.List;

public class TickerParameters {
    private String channel = CryptoApiChannelsEnum.TICKER_CHANNEL.getValue();
    private List<String> symbol;
    private String event_trigger;
    private Boolean snapshot;

    public TickerParameters(List<String> symbols, CryptoApiEventTriggerEnum eventTrigger, Boolean snapshot) {
        this.symbol = symbols;
        this.event_trigger = eventTrigger.getValue();
        this.snapshot = snapshot;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public List<String> getSymbol() {
        return symbol;
    }

    public void setSymbol(List<String> symbol) {
        this.symbol = symbol;
    }

    public String getEvent_trigger() {
        return event_trigger;
    }

    public void setEvent_trigger(String event_trigger) {
        this.event_trigger = event_trigger;
    }

    public Boolean getSnapshot() {
        return snapshot;
    }

    public void setSnapshot(Boolean snapshot) {
        this.snapshot = snapshot;
    }
}
