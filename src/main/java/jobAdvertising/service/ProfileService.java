package jobAdvertising.service;

import jobAdvertising.domain.Profile;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ProfileService {
    public Profile createProfile() {
        Scanner scanner = new Scanner(System.in);
        Profile profile = new Profile();

        System.out.println("Enter your name:");
        profile.setName(scanner.nextLine());

        System.out.println("Enter your contact number:");
        profile.setContactNumber(scanner.nextInt());

        System.out.println("Do you want to upload an image? (Y/N)");
        String uploadChoice = scanner.next();

        if (uploadChoice.equalsIgnoreCase("Y")) {
            System.out.println("Enter the image path:");
            profile.setImagePath(scanner.next());
        }

        return profile;
    }

    public void displayProfile(Profile profile) {
        System.out.println("Profile Details:");
        System.out.println("Name: " + profile.getName());
        System.out.println("Contact Number: " + profile.getContactNumber());

        if (profile.getImagePath() != null && !profile.getImagePath().isEmpty()) {
            System.out.println("Image Path: " + profile.getImagePath());
        } else {
            System.out.println("No image data available.");
        }
    }
}
