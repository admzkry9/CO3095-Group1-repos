package jobAdvertising;

import jobAdvertising.service.ApplicantService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicantListingRunner implements CommandLineRunner {

    private final ApplicantService applicantService;

    public ApplicantListingRunner(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @Override
    public void run(String... args) throws Exception {
        listAllApplicants();
    }

    private void listAllApplicants() {
        System.out.println("List of Available Applicants:");
        applicantService.getAllApplicants().forEach(applicant -> System.out.println(applicant.getEmail()));
    }
}
