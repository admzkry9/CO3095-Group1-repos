package jobAdvertising;

import jobAdvertising.domain.Job;
import jobAdvertising.service.JobService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class JobFilteringRunner implements CommandLineRunner {

    private final JobService jobService;

    public JobFilteringRunner(JobService jobService) {
        this.jobService = jobService;
    }

    @Override
    public void run(String... args) throws Exception {
        filterJobsByLocation();
    }

    private void filterJobsByLocation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter desired job location:");
        String requiredLocation = scanner.nextLine();

        List<Job> filteredJobs = jobService.filterJobsByLocation(requiredLocation);

        System.out.println("Filtered Jobs (Location: " + requiredLocation + "):");
        filteredJobs.forEach(job -> System.out.println(job.getTitle()));
    }
}
