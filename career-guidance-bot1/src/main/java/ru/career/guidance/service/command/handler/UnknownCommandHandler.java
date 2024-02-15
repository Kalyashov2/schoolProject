package ru.career.guidance.service.command.handler;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.career.guidance.action.CommandActions;
import ru.career.guidance.action.SendMessageAction;
import ru.career.guidance.config.BotConfig;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UnknownCommandHandler implements CommandHandler<SendMessage> {

    private final BotConfig config;

    @Override
    public CommandActions handle(Update update) {
        val chatId = update.getMessage().getChatId().toString();
        val sma = new SendMessageAction(chatId, config.getMessages().getUnknownCommand());

        return new CommandActions(List.of(sma));
    }
}
