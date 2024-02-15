package ru.career.guidance.service.command;

import org.springframework.stereotype.Component;
import ru.career.guidance.business.command.Command;
import ru.career.guidance.service.command.handler.CommandHandler;
import ru.career.guidance.service.command.handler.StartCommandHandler;
import ru.career.guidance.service.command.handler.UnknownCommandHandler;

import java.util.HashMap;
import java.util.Map;

@Component
public class CommandRegister {

    public final Map<Command, CommandHandler<?>> botCommands = new HashMap<>();

    public CommandRegister(
            StartCommandHandler startCommandHandler,
            UnknownCommandHandler unknownCommandHandler) {
        botCommands.put(Command.START, startCommandHandler);
        botCommands.put(Command.UNKNOWN, unknownCommandHandler);
    }

    public CommandHandler<?> getHandlerByCommand(Command command) {
        return botCommands.get(command);
    }
}
