package jobAdvertising.service;

import jobAdvertising.domain.Rating;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class RatingService {
    public Rating provideRating() {
        Scanner scanner = new Scanner(System.in);
        Rating rating = new Rating();

        System.out.println("Enter your rating (out of 5):");
        rating.setRating(scanner.nextDouble());

        return rating;
    }

    public void displayRating(Rating rating) {
        System.out.println("Rating Details:");
        System.out.println("Your Rating: " + rating.getRating());
    }
}

