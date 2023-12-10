package jobAdvertising;

import jobAdvertising.domain.Advertisement;
import jobAdvertising.service.DisplayAdvertisementService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DisplayAdvertisementRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {
        // Create sample advertisements
        List<Advertisement> advertisements = createSampleAdvertisements();

        // Display advertisements using the service
        DisplayAdvertisementService displayService = new DisplayAdvertisementService();
        displayService.displayAdvertisements(advertisements);
    }

    private static List<Advertisement> createSampleAdvertisements() {
        List<Advertisement> advertisements = new ArrayList<>();

        Advertisement ad1 = new Advertisement();
        ad1.setDetails("Software Engineer");
        ad1.setLocation("San Francisco");
        ad1.setContactDetails("hr@company1.com");
        ad1.setImagePath("image1.jpg");

        Advertisement ad2 = new Advertisement();
        ad2.setDetails("Data Analyst");
        ad2.setLocation("New York");
        ad2.setContactDetails("hr@company2.com");
        ad2.setImagePath("image2.jpg");

        Advertisement ad3 = new Advertisement();
        ad3.setDetails("Marketing Specialist");
        ad3.setLocation("Los Angeles");
        ad3.setContactDetails("hr@company3.com");
        ad3.setImagePath("image3.jpg");

        advertisements.add(ad1);
        advertisements.add(ad2);
        advertisements.add(ad3);

        return advertisements;
    }
}
