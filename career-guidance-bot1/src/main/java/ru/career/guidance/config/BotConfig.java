package ru.career.guidance.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "settings")
public class BotConfig {

    private @Getter @Setter Bot bot;
    private @Getter @Setter Messages messages;

    public static class Bot {
        private @Getter @Setter String name;
        private @Getter @Setter String token;
    }

    public static class Messages {
        private @Getter @Setter String unknownCommand;
    }
}
