package com.example.crypto_trading_sim;

import com.example.crypto_trading_sim.crypto.api.CryptoApiSocketClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
@EnableScheduling
public class CryptoTradingSimApplication {

	public static void main(String[] args) throws InterruptedException, URISyntaxException {

		SpringApplication.run(CryptoTradingSimApplication.class, args);

	}
}
