package ru.career.guidance.repository;

import java.util.Map;

public interface AnswerRepository {
    void saveAnswer(String userId, String questionId, Integer answer);

    Map<String, Integer> getAnswers(String userId);
}
