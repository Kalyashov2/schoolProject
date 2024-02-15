package ru.career.guidance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class CareerGuidanceBotApplication {
    private final Logger log = LoggerFactory.getLogger(CareerGuidanceBot.class);

    public CareerGuidanceBotApplication(CareerGuidanceBot bot) {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(bot);
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(CareerGuidanceBotApplication.class, args);
    }

}
