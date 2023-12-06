package jobAdvertising.service;

import jobAdvertising.domain.NonAvailableDate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ApplicantMeetingService {
    public void scheduleMeeting(LocalDate meetingDate) {
        System.out.println("Meeting scheduled for: " + meetingDate);
    }

    public void displayAvailableMeetingDates(List<NonAvailableDate> nonAvailableDates) {
        System.out.println("Available Meeting Dates:");

        LocalDate currentDate = LocalDate.now();
        while (currentDate.isBefore(currentDate.plusMonths(1))) {
            if (isDateAvailable(currentDate, nonAvailableDates)) {
                System.out.println(currentDate);
            }
            currentDate = currentDate.plusDays(1);
        }
    }

    private boolean isDateAvailable(LocalDate date, List<NonAvailableDate> nonAvailableDates) {
        for (NonAvailableDate nonAvailableDate : nonAvailableDates) {
            if (nonAvailableDate.getDate().equals(date)) {
                return false;
            }
        }
        return true;
    }
}
