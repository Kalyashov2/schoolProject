package ru.career.guidance.service.callback;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.career.guidance.action.CommandActions;
import ru.career.guidance.action.DeleteMessageAction;
import ru.career.guidance.action.SendMessageAction;
import ru.career.guidance.business.callback.CallbackAnswerType;
import ru.career.guidance.service.answer.AnswerService;
import ru.career.guidance.service.command.builder.SendWordsMessageActionBuilder;
import ru.career.guidance.service.question.QuestionService;
import ru.career.guidance.util.SendMessageBuilder;

import java.util.List;


@Component
@RequiredArgsConstructor
public class CallbackService {

    private final SendWordsMessageActionBuilder messageActionBuilder;
    private final QuestionService questionService;
    private final AnswerService answerService;

    public CommandActions handleCallback(Update update) {
        val callbackQuery = update.getCallbackQuery();
        val chatId = callbackQuery.getMessage().getChatId();
        val messageId = callbackQuery.getMessage().getMessageId();
        val userId = callbackQuery.getFrom().getId();
        val callbackRaw = callbackQuery.getData();
        val commandActions = new CommandActions();
        val callbackType = CallbackAnswerType.fromValue(callbackRaw);

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
