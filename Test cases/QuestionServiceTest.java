package jobAdvertising.tests;

import jobAdvertising.domain.Question;
import jobAdvertising.service.QuestionService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class QuestionServiceTest {
    @Test
    public void testGetQuestions() {
        QuestionService questionService = new QuestionService();

        List<Question> questions = questionService.getQuestions();

        assertNotNull(questions);
        assertEquals(2, questions.size());

    }
}
