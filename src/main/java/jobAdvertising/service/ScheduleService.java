package jobAdvertising.service;

import jobAdvertising.domain.NonAvailableDate;
import jobAdvertising.domain.Schedule;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class ScheduleService {
    private final List<NonAvailableDate> nonAvailableDates = new ArrayList<>();

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

    public void setNonAvailableDates() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter non-available dates for meetings (yyyy-MM-dd), type 'done' when finished:");

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                LocalDate date = LocalDate.parse(input);
                NonAvailableDate nonAvailableDate = new NonAvailableDate();
                nonAvailableDate.setDate(date);
                nonAvailableDates.add(nonAvailableDate);
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter dates in the format yyyy-MM-dd.");
            }
        }

        System.out.println("Non-available dates set successfully!");
    }

    public List<NonAvailableDate> getNonAvailableDates() {
        return nonAvailableDates;
    }
}
