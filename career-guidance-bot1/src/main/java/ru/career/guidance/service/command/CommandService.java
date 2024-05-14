package ru.career.guidance.service.command;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.career.guidance.action.CommandActions;
import ru.career.guidance.business.command.Command;

@Service
public class CommandService {

    public final CommandRegister commandRegister;

    public CommandService(CommandRegister commandRegister) {
        this.commandRegister = commandRegister;
    }

    public CommandActions handleCommand(Update update) {
        var command = Command.UNKNOWN;

        if (update != null && update.hasMessage() && update.getMessage().hasText()) {
            command = Command.fromValue(update.getMessage().getText());
        }

        return commandRegister.getHandlerByCommand(command).handle(update);
    }
}
