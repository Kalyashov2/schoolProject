package ru.career.guidance.service.command.builder;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;


import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SendWordsMessageActionBuilder {

//    private final UserService userService;
//    private final WordService wordService;
//    private final BotConfig config;
//
//    public CommandActions build(String chatId, Long userId) {
//        val commandActions = new CommandActions();
//        val userEntity = userService.getById(userId);
//
//        if (userEntity.getLearningStatus() == UserLearningStatus.FINISHED) {
//            userService.restartLearnProcess(userEntity);
//        }
//
//        var words = wordService.getWords(userEntity, config.getSettings().getWordsPageSize());
//
//        if (words.isEmpty()) {
//            commandActions.add(buildMessageAction(chatId, config.getMessages().getAllWordsLearned(), null));
//            userService.restartLearnProcess(userEntity);
//            words = wordService.getWords(userEntity, config.getSettings().getWordsPageSize());
//        }
//
//        val wordsText = buildWordsText(words);
//
//        val wordIds = words.stream().map(Word::getId).collect(Collectors.toList());
//        val callbackData = String.join(",", wordIds);
//
//        commandActions.add(buildMessageAction(chatId, wordsText, callbackData));
//
//        return commandActions;
//    }
//
//    public CommandActions buildAudioMessage(String chatId, List<String> wordIds) {
//        val commandActions = new CommandActions();
//        val words = wordService.getWordsByIds(wordIds);
//
//        for (val word : words) {
//            commandActions.add(buildAudioAction(chatId, word));
//        }
//
//        return commandActions;
//    }
//
//    public SendMessageAction buildMessageAction(String chatId, String text, String callbackData) {
//        val wordsMsg = new SendMessage(chatId, text);
//        wordsMsg.enableMarkdown(true);
//
//        if (callbackData != null && !callbackData.isBlank()) {
//            wordsMsg.setReplyMarkup(buildInlineKeyboard(callbackData));
//        }
//
//        return new SendMessageAction(wordsMsg);
//    }
//
//    public SendAudioAction buildAudioAction(String chatId, Word word) {
//        try {
//            val is = new URL(word.getAudio().getAudioLinkUK()).openStream();
//            val inputFile = new InputFile(is, word.toString());
//            return new SendAudioAction(chatId, inputFile);
//        } catch (IOException e) {
//            throw new RuntimeException("Ошибка при отправке аудио", e);
//        }
//    }
//
//    public InlineKeyboardMarkup buildInlineKeyboard(String callbackData) {
//
//        InlineKeyboardMarkup.InlineKeyboardMarkupBuilder builder = InlineKeyboardMarkup.builder();
//
//        builder.keyboardRow(Collections.singletonList(
//                buildBtn("\uD83C\uDFB5", CallbackType.GA + callbackData)
//        ));
//
//        return builder.build();
//    }
//
//    private String buildWordsText(List<Word> words) {
//        val wordsText = new StringBuilder();
//        int index = 1;
//        for(val word: words) {
//            wordsText.append(index)
//                    .append(". `")
//                    .append(word.getWord())
//                    .append("` (_")
//                    .append(PartOfSpeech.getShortName(word.getPartOfSpeech()))
//                    .append("_)")
//                    .append(" - ")
//                    .append(word.getTranslation())
//                    .append(" ")
//                    .append((word.getEmoji() != null) ? word.getEmoji() : "")
//                    .append("\n");
//            index++;
//        }
//
//        return wordsText.toString();
//    }
//
//    private InlineKeyboardButton buildBtn(String text, String callback) {
//        val btn = new InlineKeyboardButton();
//        btn.setText(text);
//        btn.setCallbackData(callback);
//        return btn;
//    }
}
