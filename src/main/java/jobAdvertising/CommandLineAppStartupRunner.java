package jobAdvertising;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import jobAdvertising.service.EmailService;

import java.util.Scanner;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final EmailService emailService;

    public CommandLineAppStartupRunner(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter sender's email: ");
        String sender = scanner.nextLine();
        System.out.println("Enter recipient's email: ");
        String recipient = scanner.nextLine();
        System.out.println("Enter subject: ");
        String subject = scanner.nextLine();
        System.out.println("Enter email body: ");
        String body = scanner.nextLine();

        emailService.sendEmail(sender, recipient, subject, body); // Use the emailService instance
    }

}
