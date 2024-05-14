package ru.career.guidance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.career.guidance.action.BotAction;
import ru.career.guidance.config.BotConfig;
import ru.career.guidance.controller.BotUpdateController;

import java.util.List;


@Service
public class CareerGuidanceBot extends TelegramLongPollingBot {
    private final Logger log = LoggerFactory.getLogger(CareerGuidanceBot.class);
    private final BotConfig config;
    private final BotUpdateController updateController;

    public CareerGuidanceBot(BotConfig config, BotUpdateController updateController) {
        super(config.getBot().getToken());
        this.config = config;
        this.updateController = updateController;
    }

    @Override
    public String getBotUsername() {
        return config.getBot().getName();
    }

    @Override
    public void onUpdateReceived(Update update) {
        log.info(update.toString());
        processActions(updateController.onUpdate(update).getActions());
    }

    public void processActions(List<BotAction<?>> actions) {
        try {
            for (var action : actions) {
                log.info(action.getAction().toString());

                switch (action.getActionType()) {
                    case SEND_MESSAGE:
                        execute((SendMessage) action.getAction());
                        break;
                    case DELETE_MESSAGE:
                        execute((DeleteMessage) action.getAction());
                        break;
                    case NONE:
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
