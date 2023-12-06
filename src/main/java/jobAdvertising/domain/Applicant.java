package jobAdvertising.domain;

import java.util.List;

public class Applicant {
    private String email;
    private String employmentType; // "fullTime" or "partTime"
    private int workExperienceInYears;
    private List<String> skills;
    private String areaOfExpertise;

    public String getAreaOfExpertise() {
        return areaOfExpertise;
    }

    public void setAreaOfExpertise(String areaOfExpertise) {
        this.areaOfExpertise = areaOfExpertise;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public int getWorkExperienceInYears() {
        return workExperienceInYears;
    }

    public void setWorkExperienceInYears(int workExperienceInYears) {
        this.workExperienceInYears = workExperienceInYears;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}
