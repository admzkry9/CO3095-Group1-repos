package jobAdvertising.service;

import jobAdvertising.domain.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(createQuestion("What is your experience in Java?"));
        questions.add(createQuestion("How do you handle challenges in a team setting?"));
        return questions;
    }

    private Question createQuestion(String content) {
        Question question = new Question();
        question.setContent(content);
        return question;
    }
}
