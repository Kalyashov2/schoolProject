package ru.career.guidance.service.command.handler;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.career.guidance.action.CommandActions;
import ru.career.guidance.action.SendMessageAction;
import ru.career.guidance.service.question.QuestionService;
import ru.career.guidance.util.SendMessageBuilder;

@Component
@RequiredArgsConstructor
public class StartCommandHandler implements CommandHandler<SendMessage> {

    private final QuestionService questionService;

    @Override
    public CommandActions handle(Update update) {
        val chatId = update.getMessage().getChatId();

        val firstQuestion = questionService.getQuestionById(1);
        val sm = SendMessageBuilder.buildQuestionMsg(chatId, 1, firstQuestion);

        return new CommandActions(new SendMessageAction(sm));
    }
}
