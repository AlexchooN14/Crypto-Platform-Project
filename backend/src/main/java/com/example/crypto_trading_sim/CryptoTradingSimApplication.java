package com.example.crypto_trading_sim;

import com.example.crypto_trading_sim.crypto.api.CryptoApiConstants;
import com.example.crypto_trading_sim.crypto.api.SubscribeRequestProvider;
import com.example.crypto_trading_sim.services.CryptoApiSocketClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@SpringBootApplication
public class CryptoTradingSimApplication {

	public static void main(String[] args) throws InterruptedException, URISyntaxException {

//		SpringApplication.run(CryptoTradingSimApplication.class, args);

		URI uri = new URI("wss://ws.kraken.com/v2");

		CryptoApiSocketClient client = new CryptoApiSocketClient(uri);
		client.connectBlocking();  // blocks until connected

		// Keep the app alive for some time to receive messages
		Thread.sleep(60000);  // 1 minute

		client.close();
	}
}
