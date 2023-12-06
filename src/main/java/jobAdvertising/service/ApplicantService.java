package jobAdvertising.service;

import jobAdvertising.domain.Applicant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicantService {
    private final List<Applicant> applicants = new ArrayList<>();

    public void addApplicant(Applicant applicant) {
        applicants.add(applicant);
    }

    public List<Applicant> getAllApplicants() {
        return new ArrayList<>(applicants);
    }

    public List<Applicant> filterApplicantsBySkills(List<String> requiredSkills) {
        return applicants.stream()
                .filter(applicant -> applicant.getSkills().containsAll(requiredSkills))
                .collect(Collectors.toList());
    }
    public List<Applicant> filterApplicantsByAreaOfExpertise(String requiredExpertise) {
        return applicants.stream()
                .filter(applicant -> applicant.getAreaOfExpertise().equalsIgnoreCase(requiredExpertise))
                .collect(Collectors.toList());
    }
}
