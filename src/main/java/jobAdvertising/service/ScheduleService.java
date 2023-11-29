package jobAdvertising.service;

import jobAdvertising.domain.Schedule;
import org.springframework.stereotype.Service;

import java.util.Scanner;


@Service
public class ScheduleService {
    public Schedule setScheduleWithEmployer() {
        Scanner scanner = new Scanner(System.in);
        Schedule schedule = new Schedule();

        System.out.println("Enter the date with the employer (e.g., 2023-12-01):");
        schedule.setDateWithEmployer(scanner.nextLine());

        return schedule;
    }

    public void displaySchedule(Schedule schedule) {
        System.out.println("Schedule Details:");
        System.out.println("Date with Employer: " + schedule.getDateWithEmployer());
    }
}

