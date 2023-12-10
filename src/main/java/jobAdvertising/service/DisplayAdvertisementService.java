package jobAdvertising.service;

import jobAdvertising.domain.Advertisement;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DisplayAdvertisementService {

    public void displayAdvertisements(List<Advertisement> advertisements) {
        if (advertisements.isEmpty()) {
            System.out.println("No job advertisements available.");
        } else {
            System.out.println("Available Job Advertisements:");
            for (Advertisement advertisement : advertisements) {
                displaySingleAdvertisement(advertisement);
            }
        }
    }

    public void displaySingleAdvertisement(Advertisement advertisement) {
        System.out.println("Job Title: " + getValueOrDefault(advertisement.getDetails()));
        System.out.println("Location: " + getValueOrDefault(advertisement.getLocation()));
        System.out.println("Contact Details: " + getValueOrDefault(advertisement.getContactDetails()));
        System.out.println("Image Path: " + getValueOrDefault(advertisement.getImagePath()));
        System.out.println("----------------------------------------");
    }

    private String getValueOrDefault(String value) {
        return value != null ? value : "N/A";
    }
}
