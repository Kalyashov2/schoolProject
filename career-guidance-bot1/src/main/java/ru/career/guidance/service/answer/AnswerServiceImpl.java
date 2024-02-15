package ru.career.guidance.service.answer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.career.guidance.repository.AnswerRepository;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository repository;

    @Override
    public void saveAnswer(String userId, String questionId, Integer answer) {
        repository.saveAnswer(userId, questionId, answer);
    }
}
