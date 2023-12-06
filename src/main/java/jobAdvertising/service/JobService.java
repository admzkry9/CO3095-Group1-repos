package jobAdvertising.service;

import jobAdvertising.domain.Job;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobService {
    private final List<Job> jobs = new ArrayList<>();

    public void addJob(Job job) {
        jobs.add(job);
    }

    public List<Job> getAllJobs() {
        return new ArrayList<>(jobs);
    }

    public List<Job> filterJobsByLocation(String requiredLocation) {
        return jobs.stream()
                .filter(job -> job.getLocation().equalsIgnoreCase(requiredLocation))
                .collect(Collectors.toList());
    }
}
