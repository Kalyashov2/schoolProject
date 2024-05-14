package ru.career.guidance.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


@Repository
public class AnswerRepositoryImpl implements AnswerRepository {

    private final Map<String, Map<String, Integer>> answers = new HashMap<>();

    @Override
    public void saveAnswer(String userId, String questionId, Integer answer) {
        var userAnswers = answers.get(userId);

        if (userAnswers == null) {
            userAnswers = new HashMap<>();
        }

        userAnswers.put(questionId, answer);

        answers.put(userId, userAnswers);
    }

    @Override
    public Map<String, Integer> getAnswers(String userId) {
        return answers.get(userId);
    }
}
