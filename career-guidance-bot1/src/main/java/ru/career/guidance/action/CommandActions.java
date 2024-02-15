package ru.career.guidance.action;

import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Набор действий, выполняемых в рамках обработки команды
 */
public class CommandActions {
    private final List<BotAction<?>> actions;

    public CommandActions() {
        this.actions = new ArrayList<>();
    }

    public CommandActions(BotAction<?> action) {
        this.actions = Collections.singletonList(action);
    }

    public CommandActions(List<BotAction<? extends PartialBotApiMethod<Message>>> actions) {
        this.actions = new ArrayList<>();
        this.actions.addAll(actions);
    }

    public <T extends PartialBotApiMethod<?>> void add(BotAction<T> action) {
        actions.add(action);
    }

    public <T extends PartialBotApiMethod<?>> void addAll(List<BotAction<?>> actions) {
        this.actions.addAll(actions);
    }

    public <T extends PartialBotApiMethod<?>> List<BotAction<?>> getActions() {
        return actions;
    }

    public static CommandActions empty() {
        return new CommandActions(new ArrayList<>());
    }
}
