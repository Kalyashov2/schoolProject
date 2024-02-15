package ru.career.guidance.service.command.handler;

import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.career.guidance.action.CommandActions;

/**
 * Обработчик команды
 * @param <T> метод API telegram, который надо выполнить в ответ на команду
 */
public interface CommandHandler<T extends PartialBotApiMethod<?>> {
    CommandActions handle(Update update);
}
