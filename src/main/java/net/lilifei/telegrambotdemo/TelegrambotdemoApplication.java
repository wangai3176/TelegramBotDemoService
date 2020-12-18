package net.lilifei.telegrambotdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class TelegrambotdemoApplication {

	public static void main(String[] args) {
		ApiContextInitializer.init();
		SpringApplication.run(TelegrambotdemoApplication.class, args);
	}

}
