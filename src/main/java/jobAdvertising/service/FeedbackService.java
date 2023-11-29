package jobAdvertising.service;

import jobAdvertising.domain.Feedback;
import org.springframework.stereotype.Service;

import java.util.Scanner;
@Service
public class FeedbackService {
    public Feedback provideFeedback() {
        Scanner scanner = new Scanner(System.in);
        Feedback feedback = new Feedback();

        System.out.println("Enter your feedback:");
        feedback.setFeedbackText(scanner.nextLine());

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
