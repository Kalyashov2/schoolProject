package ru.career.guidance.action;

import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;

public class DeleteMessageAction implements BotAction<DeleteMessage> {

    private final DeleteMessage deleteMessage;

    public DeleteMessageAction(String chatId, Integer messageId) {
        this.deleteMessage = new DeleteMessage(chatId, messageId);
    }

    @Override
    public BotActionType getActionType() {
        return BotActionType.DELETE_MESSAGE;
    }

    @Override
    public DeleteMessage getAction() {
        return deleteMessage;
    }
}
