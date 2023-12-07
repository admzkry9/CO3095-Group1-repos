package jobAdvertising.tests;

import jobAdvertising.domain.Feedback;
import jobAdvertising.domain.Question;
import jobAdvertising.service.FeedbackService;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class testProvideFeedback {
    @Test
    public void testProvideFeedback() {
        String input = "Answer 1\nAnswer 2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        List<Question> questions = new ArrayList<>();
        questions.add(createQuestion("Question 1"));
        questions.add(createQuestion("Question 2"));

        FeedbackService feedbackService = new FeedbackService();
        Feedback feedback = feedbackService.provideFeedback(questions);

        System.setIn(System.in);

        assertEquals("Answer 1\nAnswer 2\n", feedback.getFeedbackText());
    }

    @Test
    public void testReplyToFeedback() {
        FeedbackService feedbackService = new FeedbackService();
        Feedback feedback = new Feedback();
        feedbackService.replyToFeedback(feedback, "Test Reply");
        assertEquals("Test Reply", feedback.getReply());
    }
    private Question createQuestion(String content) {
        Question question = new Question();
        question.setContent(content);
        return question;
    }
}

