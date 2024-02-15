package ru.career.guidance.action;

import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;

/**
 * Действие, которое может выполнить бот
 * @param <T> действие
 */
public interface BotAction<T extends PartialBotApiMethod<?>> {

    /**
     * @return тип действия
     */
    BotActionType getActionType();

    /**
     * @return действие
     */
    T getAction();
}
