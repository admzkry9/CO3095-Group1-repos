package jobAdvertising.tests;

import jobAdvertising.domain.Job;
import jobAdvertising.service.JobService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class JobServiceTest {
    @Test
    public void testAddJobAndGetAllJobs() {
        JobService jobService = new JobService();


        Job testJob = new Job();
        testJob.setTitle("Software Engineer");
        testJob.setLocation("City Center");
        testJob.setDescription("Exciting software development opportunity");


        jobService.addJob(testJob);


        List<Job> allJobs = jobService.getAllJobs();


        assertEquals(1, allJobs.size());
        assertEquals(testJob, allJobs.get(0));
    }

    @Test
    public void testFilterJobsByLocation() {
        JobService jobService = new JobService();

        Job job1 = new Job();
        job1.setTitle("Web Developer");
        job1.setLocation("Downtown");

        Job job2 = new Job();
        job2.setTitle("Data Analyst");
        job2.setLocation("Midtown");

        Job job3 = new Job();
        job3.setTitle("UX Designer");
        job3.setLocation("Downtown");
        jobService.addJob(job1);
        jobService.addJob(job2);
        jobService.addJob(job3);


        List<Job> filteredJobs = jobService.filterJobsByLocation("Downtown");

        assertEquals(2, filteredJobs.size());
        assertEquals(job1, filteredJobs.get(0));
        assertEquals(job3, filteredJobs.get(1));
    }
}

