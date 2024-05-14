package ru.career.guidance.service.callback;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.career.guidance.action.CommandActions;
import ru.career.guidance.action.DeleteMessageAction;
import ru.career.guidance.action.SendMessageAction;
import ru.career.guidance.business.callback.CallbackAnswerType;
import ru.career.guidance.service.answer.AnswerService;
import ru.career.guidance.service.question.QuestionService;
import ru.career.guidance.util.SendMessageBuilder;

import java.util.List;


@Component
public class CallbackService {

    private final QuestionService questionService;
    private final AnswerService answerService;

    public CallbackService(QuestionService questionService, AnswerService answerService) {
        this.questionService = questionService;
        this.answerService = answerService;
    }

    public CommandActions handleCallback(Update update) {
        var callbackQuery = update.getCallbackQuery();
        var chatId = callbackQuery.getMessage().getChatId();
        var messageId = callbackQuery.getMessage().getMessageId();
        var userId = callbackQuery.getFrom().getId();
        var callbackRaw = callbackQuery.getData();
        var commandActions = new CommandActions();
        var callbackType = CallbackAnswerType.fromValue(callbackRaw);

        handleCallback(callbackType, commandActions, messageId, chatId, callbackRaw);

        return commandActions;
    }

    private void handleCallback(CallbackAnswerType callbackAnswerType, CommandActions commandActions,
                                Integer messageId, Long chatId, String callbackRaw) {
        String[] callbackData = callbackRaw.split(":");
        int questionId = Integer.parseInt(callbackData[1]);

        answerService.saveAnswer(chatId.toString(), String.valueOf(questionId), callbackAnswerType.getScore());

        int nextQuestionId = ++questionId;

        String nextQuestion = questionService.getQuestionById(nextQuestionId);

        SendMessage sm = SendMessageBuilder.buildQuestionMsg(chatId, nextQuestionId, nextQuestion);
        commandActions.addAll(List.of(
                new DeleteMessageAction(chatId.toString(), messageId),
                new SendMessageAction(sm)));
    }
}
