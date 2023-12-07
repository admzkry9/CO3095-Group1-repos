package jobAdvertising;

import jobAdvertising.domain.Rating;
import jobAdvertising.service.RatingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class RatingRunner implements CommandLineRunner {

    private final RatingService ratingService;

    public RatingRunner(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select an option:");
        System.out.println("1. Provide and Display Rating");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                provideAndDisplayRating();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private void provideAndDisplayRating() {
        Rating rating = ratingService.provideRating();
        ratingService.displayRating(rating);
    }
}
