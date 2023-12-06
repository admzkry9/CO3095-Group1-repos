package jobAdvertising;

import jobAdvertising.domain.Applicant;
import jobAdvertising.service.ApplicantService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ApplicantFilteringRunner implements CommandLineRunner {

    private final ApplicantService applicantService;

    public ApplicantFilteringRunner(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @Override
    public void run(String... args) throws Exception {
        filterApplicantsBySkills();
    }

    private void filterApplicantsBySkills() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter required skills (comma-separated):");
        String skillsInput = scanner.nextLine();
        List<String> requiredSkills = List.of(skillsInput.split("\\s*,\\s*"));

        List<Applicant> filteredApplicants = applicantService.filterApplicantsBySkills(requiredSkills);

        System.out.println("Filtered Applicants (Required Skills: " + requiredSkills + "):");
        filteredApplicants.forEach(applicant -> System.out.println(applicant.getEmail()));
    }
    private void filterApplicantsByAreaOfExpertise() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter desired area of expertise:");
        String requiredExpertise = scanner.nextLine();

        List<Applicant> filteredApplicants = applicantService.filterApplicantsByAreaOfExpertise(requiredExpertise);

        System.out.println("Filtered Applicants (Area of Expertise: " + requiredExpertise + "):");
        filteredApplicants.forEach(applicant -> System.out.println(applicant.getEmail()));
    }
}