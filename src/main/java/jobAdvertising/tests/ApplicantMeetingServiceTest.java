package jobAdvertising.tests;

import jobAdvertising.domain.NonAvailableDate;
import jobAdvertising.service.ApplicantMeetingService;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ApplicantMeetingServiceTest {

    @Test
    public void testScheduleMeeting() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        LocalDate meetingDate = LocalDate.now().plusDays(3);
        ApplicantMeetingService meetingService = new ApplicantMeetingService();
        meetingService.scheduleMeeting(meetingDate);

        System.setOut(System.out);

        assertTrue("Incorrect meeting scheduling",
                outContent.toString().contains("Meeting scheduled for: " + meetingDate));
    }
}

