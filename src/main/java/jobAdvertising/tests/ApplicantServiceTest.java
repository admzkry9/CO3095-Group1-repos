package jobAdvertising.tests;

import jobAdvertising.domain.Applicant;
import jobAdvertising.service.ApplicantService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ApplicantServiceTest {
    @Test
    public void testAddAndFilterApplicants() {
        ApplicantService applicantService = new ApplicantService();


        Applicant applicant1 = new Applicant();
        applicant1.setSkills(List.of("Java", "Spring"));
        applicant1.setAreaOfExpertise("Backend");

        Applicant applicant2 = new Applicant();
        applicant2.setSkills(List.of("JavaScript", "React"));
        applicant2.setAreaOfExpertise("Frontend");

        Applicant applicant3 = new Applicant();
        applicant3.setSkills(List.of("Java", "React"));
        applicant3.setAreaOfExpertise("Fullstack");

        applicantService.addApplicant(applicant1);
        applicantService.addApplicant(applicant2);
        applicantService.addApplicant(applicant3);


        List<Applicant> allApplicants = applicantService.getAllApplicants();
        assertEquals(3, allApplicants.size());

        String requiredExpertise = "Backend";
        List<Applicant> filteredByExpertise = applicantService.filterApplicantsByAreaOfExpertise(requiredExpertise);
        assertEquals(1, filteredByExpertise.size());
    }
}
