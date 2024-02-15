package ru.career.guidance.action;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

/**
 * Отправка текстового сообщения
 */
public class SendMessageAction implements BotAction<SendMessage> {

    private final SendMessage sendMessage;

    public SendMessageAction(SendMessage sendMessage) {
        this.sendMessage = sendMessage;
    }

    public SendMessageAction(String chatId, String text) {
        sendMessage = new SendMessage(chatId, text);
    }

    public SendMessageAction(String chatId, String text, ReplyKeyboard keyboard) {
        sendMessage = SendMessage.builder()
                .chatId(chatId)
                .text(text)
                .replyMarkup(keyboard)
                .build();
    }

    public SendMessageAction(String chatId, String text, ReplyKeyboard keyboard, boolean enableMarkdown) {
        sendMessage = SendMessage.builder()
                .chatId(chatId)
                .text(text)
                .replyMarkup(keyboard)
                .build();

        sendMessage.enableMarkdown(enableMarkdown);
    }

    @Override
    public BotActionType getActionType() {
        return BotActionType.SEND_MESSAGE;
    }

    @Override
    public SendMessage getAction() {
        return sendMessage;
    }
}
