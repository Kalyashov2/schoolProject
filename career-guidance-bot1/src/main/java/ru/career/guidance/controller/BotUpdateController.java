package ru.career.guidance.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.career.guidance.CareerGuidanceBot;
import ru.career.guidance.action.CommandActions;
import ru.career.guidance.service.callback.CallbackService;
import ru.career.guidance.service.command.CommandService;


/**
 * Контроллер для обработки update'ов от бота
 */
@Controller
public class BotUpdateController {

    private final Logger log = LoggerFactory.getLogger(CareerGuidanceBot.class);

    private final CommandService commandService;
    private final CallbackService callbackService;

    public BotUpdateController(CommandService commandService, CallbackService callbackService) {
        this.commandService = commandService;
        this.callbackService = callbackService;
    }

    public CommandActions onUpdate(Update update) {
        log.info(update.toString());

        if (isMessage(update)) {
            return commandService.handleCommand(update);
        } else if (isCallback(update)) {
            return callbackService.handleCallback(update);
        }

        return CommandActions.empty();
    }

    private boolean isMessage(Update update) {
        return update.hasMessage() && update.getMessage().hasText() && !update.getMessage().hasSuccessfulPayment();
    }

    private boolean isCallback(Update update) {
        return update.hasCallbackQuery() && update.getCallbackQuery().getData() != null;
    }
}
