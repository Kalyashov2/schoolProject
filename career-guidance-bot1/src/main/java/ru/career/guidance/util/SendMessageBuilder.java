package ru.career.guidance.util;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.career.guidance.business.callback.CallbackAnswerType;

import java.util.Arrays;
import java.util.List;

public class SendMessageBuilder {

    private static final String DELIMITER = ":";

    public static SendMessage build(String chatId, String text) {
        return new SendMessage(chatId, text);
    }

    public static SendMessage buildQuestionMsg(Long chatId, Integer questionId, String questionText) {
        SendMessage sm = new SendMessage(chatId.toString(), questionText);
        sm.enableHtml(true);

        sm.setReplyMarkup(buildAnswerData(questionId.toString(), false, false));

        return sm;
    }

    public static InlineKeyboardMarkup buildAnswerData(String callbackData, boolean needPrevBtn, boolean needNextBtn) {

        InlineKeyboardMarkup.InlineKeyboardMarkupBuilder builder = InlineKeyboardMarkup.builder();

        builder.keyboardRow(Arrays.asList(
                buildBtn("❤\uFE0F Нравится", CallbackAnswerType.LIKE + DELIMITER + callbackData),
                buildBtn("\uD83E\uDD14 Не знаю", CallbackAnswerType.DONT_KNOW + DELIMITER + callbackData)
        ));

        builder.keyboardRow(List.of(
                buildBtn("\uD83E\uDD28 Сомневаюсь", CallbackAnswerType.DOUBT + DELIMITER + callbackData)
        ));

        builder.keyboardRow(Arrays.asList(
                buildBtn("\uD83D\uDC4E Не нравится", CallbackAnswerType.DONT_LIKE + DELIMITER + callbackData),
                buildBtn("\uD83D\uDCA9 Очень не нравится", CallbackAnswerType.REALLY_DONT_LIKE + DELIMITER + callbackData)

        ));

        return builder.build();
    }

    private static InlineKeyboardButton buildBtn(String text, String callback) {
        InlineKeyboardButton btn = new InlineKeyboardButton();
        btn.setText(text);
        btn.setCallbackData(callback);
        return btn;
    }
}
