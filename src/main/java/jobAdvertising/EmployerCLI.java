package jobAdvertising;

import jobAdvertising.domain.Employer;
import jobAdvertising.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
//@Order(1)
public class EmployerCLI implements CommandLineRunner {

    private final EmployerService employerService;

    @Autowired
    public EmployerCLI(EmployerService employerService) {
        this.employerService = employerService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. List all employers");
            System.out.println("2. Find employer by ID");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    listAllEmployers();
                    break;
                case 2:
                    findEmployerById();
                    break;
                case 3:
                    System.out.println("Exiting. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    private void listAllEmployers() {
        List<Employer> employers = employerService.findAllEmployers();
        employers.forEach(System.out::println);
    }

    private void findEmployerById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter employer ID:");
        Long id = scanner.nextLong();

        Employer employer = employerService.findEmployerById(id);
        if (employer != null) {
            System.out.println(employer);
        } else {
            System.out.println("Employer not found.");
        }
    }
}