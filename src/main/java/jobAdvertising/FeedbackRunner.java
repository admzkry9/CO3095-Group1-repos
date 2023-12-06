package jobAdvertising;

import jobAdvertising.domain.Feedback;
import jobAdvertising.domain.Question;
import jobAdvertising.service.FeedbackService;
import jobAdvertising.service.QuestionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class FeedbackRunner implements CommandLineRunner {

    private final FeedbackService feedbackService;
    private final QuestionService questionService;

    public FeedbackRunner(FeedbackService feedbackService, QuestionService questionService) {
        this.feedbackService = feedbackService;
        this.questionService = questionService;
    }

    @Override
    public void run(String... args) throws Exception {
        provideAndDisplayFeedback();
    }

    private void provideAndDisplayFeedback() {
        List<Question> questions = questionService.getQuestions();

        if (!questions.isEmpty()) {
            Feedback feedback = feedbackService.provideFeedback(questions);
            feedbackService.displayFeedback(feedback);

            System.out.println("Enter your reply to the feedback:");
            String reply = new Scanner(System.in).nextLine();
            feedbackService.replyToFeedback(feedback, reply);
        } else {
            System.out.println("No questions available for feedback.");
        }
    }
}