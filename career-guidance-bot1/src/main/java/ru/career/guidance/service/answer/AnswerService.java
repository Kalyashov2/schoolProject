package ru.career.guidance.service.answer;

public interface AnswerService {
    void saveAnswer(String userId, String questionId, Integer answer);
}
