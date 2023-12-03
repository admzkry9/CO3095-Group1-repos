package jobAdvertising;

import jobAdvertising.service.ProfileService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import jobAdvertising.domain.Profile;

import java.util.Scanner;

@Component
public class ProfilePageRunner implements CommandLineRunner {

    private final ProfileService profileService;

    public ProfilePageRunner(ProfileService profileService) {
        this.profileService = profileService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select an option:");
        System.out.println("1. Create and Display Profile");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                createAndDisplayProfile();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private void createAndDisplayProfile() {
        Profile profile = profileService.createProfile();
        profileService.displayProfile(profile);
    }
}
