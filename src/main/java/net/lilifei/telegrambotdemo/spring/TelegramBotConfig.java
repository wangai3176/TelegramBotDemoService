package net.lilifei.telegrambotdemo.spring;

import net.lilifei.telegrambotdemo.bot.TelegramBot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TelegramBotConfig {

    @Value("${telegram.demo.bot.name}")
    private String name;

    @Value("${telegram.demo.bot.token}")
    private String token;

    @Bean
    TelegramBot telegramBot() {
        return new TelegramBot(name, token);
    }
}
