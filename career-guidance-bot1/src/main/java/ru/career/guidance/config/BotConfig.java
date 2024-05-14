package ru.career.guidance.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "settings")
public class BotConfig {

    private Bot bot;
    private Messages messages;

    public Bot getBot() {
        return bot;
    }

    public void setBot(Bot bot) {
        this.bot = bot;
    }

    public Messages getMessages() {
        return messages;
    }

    public void setMessages(Messages messages) {
        this.messages = messages;
    }

    public static class Bot {
        private String name;
        private String token;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }

    public static class Messages {
        private String unknownCommand;

        public String getUnknownCommand() {
            return unknownCommand;
        }

        public void setUnknownCommand(String unknownCommand) {
            this.unknownCommand = unknownCommand;
        }
    }
}
