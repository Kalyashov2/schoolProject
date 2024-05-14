package ru.career.guidance.service.command.handler;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.career.guidance.action.CommandActions;
import ru.career.guidance.action.SendMessageAction;
import ru.career.guidance.service.question.QuestionService;
import ru.career.guidance.util.SendMessageBuilder;

@Component
public class StartCommandHandler implements CommandHandler<SendMessage> {

    private final QuestionService questionService;

    public StartCommandHandler(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public CommandActions handle(Update update) {
        var chatId = update.getMessage().getChatId();

        var firstQuestion = questionService.getQuestionById(1);
        var sm = SendMessageBuilder.buildQuestionMsg(chatId, 1, firstQuestion);

        return new CommandActions(new SendMessageAction(sm));
    }
}
