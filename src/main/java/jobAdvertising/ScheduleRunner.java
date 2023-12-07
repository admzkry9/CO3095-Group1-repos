package jobAdvertising;

import jobAdvertising.domain.NonAvailableDate;
import jobAdvertising.service.ApplicantMeetingService;
import jobAdvertising.service.ScheduleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@Component
public class ScheduleRunner implements CommandLineRunner {

    private final ScheduleService scheduleService;
    private final ApplicantMeetingService applicantMeetingService;

    public ScheduleRunner(ScheduleService scheduleService, ApplicantMeetingService applicantMeetingService) {
        this.scheduleService = scheduleService;
        this.applicantMeetingService = applicantMeetingService;
    }

    @Override
    public void run(String... args) throws Exception {
        scheduleNonAvailableDates();
        displayAvailableMeetingDates();
        scheduleMeeting();
    }

    private void scheduleNonAvailableDates() {
        scheduleService.setNonAvailableDates();
    }

    private void displayAvailableMeetingDates() {
        List<NonAvailableDate> nonAvailableDates = scheduleService.getNonAvailableDates();
        applicantMeetingService.displayAvailableMeetingDates(nonAvailableDates);
    }

    private void scheduleMeeting() {
        System.out.println("Enter the date for the meeting (yyyy-MM-dd):");
        LocalDate meetingDate = LocalDate.parse(new Scanner(System.in).nextLine());
        applicantMeetingService.scheduleMeeting(meetingDate);
    }
}
