package jobAdvertising.tests;

import jobAdvertising.domain.Rating;
import jobAdvertising.service.RatingService;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class RatingServiceTest {
    @Test
    public void testProvideRating() {
        RatingService ratingService = new RatingService();
        InputStream originalSystemIn = System.in;
        ByteArrayInputStream simulatedInput = new ByteArrayInputStream("4.5\n".getBytes());
        System.setIn(simulatedInput);
        Rating rating = ratingService.provideRating();
        System.setIn(originalSystemIn);
        assertNotNull(rating);
        assertEquals(4.5, rating.getRating(), 0.001);
    }

    @Test
    public void testDisplayRating() {
        RatingService ratingService = new RatingService();

        Rating rating = new Rating();
        rating.setRating(3.8);


        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ratingService.displayRating(rating);
        System.setOut(System.out);

        assertTrue(outContent.toString().contains("Rating Details:"));
        assertTrue(outContent.toString().contains("Your Rating: 3.8"));
    }
}
