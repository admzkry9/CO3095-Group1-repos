package jobAdvertising.service;

import jobAdvertising.domain.Feedback;
import jobAdvertising.domain.Question;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;
@Service
public class FeedbackService {
    public Feedback provideFeedback(List<Question> questions) {
        Scanner scanner = new Scanner(System.in);
        Feedback feedback = new Feedback();

        System.out.println("Provide feedback for each question:");

        for (Question question : questions) {
            System.out.println("Question: " + question.getContent());
            System.out.println("Your Answer:");
            String answer = scanner.nextLine();
            System.out.println("Your Answer: " + answer);
        }

        System.out.println("Feedback submitted successfully!");
        return feedback;
    }

    public void displayFeedback(Feedback feedback) {
        System.out.println("Feedback Details:");
        System.out.println("Feedback Text: " + feedback.getFeedbackText());
    }

    public void replyToFeedback(Feedback feedback, String reply) {
        feedback.setReply(reply);
        System.out.println("Reply sent: " + reply);
    }
}
