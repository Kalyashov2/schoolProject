package ru.career.guidance.service.question;

import org.springframework.stereotype.Service;
import ru.career.guidance.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public String getQuestionById(Integer id) {
        return questionRepository.getById(id);
    }
}
