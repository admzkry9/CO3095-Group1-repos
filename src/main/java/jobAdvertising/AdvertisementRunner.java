package jobAdvertising;

import jobAdvertising.domain.Advertisement;
import jobAdvertising.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AdvertisementRunner implements CommandLineRunner {
    private final AdvertisementService advertisementService;


    public AdvertisementRunner(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter path to image file: ");
            String imagePath = scanner.nextLine();

            System.out.println("Enter job details: ");
            String details = scanner.nextLine();

            System.out.println("Enter contact details: ");
            String contactDetails = scanner.nextLine();

            Advertisement advertisement = new Advertisement();
            advertisement.setImagePath(imagePath);
            advertisement.setDetails(details);
            advertisement.setContactDetails(contactDetails);

            advertisementService.addAdvertisement(advertisement);

            System.out.println("Your job advertisement has been added!");
        } catch (Exception e) {
            // Handle or log the exception as needed
            e.printStackTrace();
        } finally {
            // Close the Scanner to avoid resource leaks
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
