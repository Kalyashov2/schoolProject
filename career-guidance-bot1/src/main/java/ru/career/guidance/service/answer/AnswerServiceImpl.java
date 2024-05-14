package ru.career.guidance.service.answer;

import org.springframework.stereotype.Service;
import ru.career.guidance.repository.AnswerRepository;

@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository repository;

    public AnswerServiceImpl(AnswerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveAnswer(String userId, String questionId, Integer answer) {
        repository.saveAnswer(userId, questionId, answer);
    }
}
