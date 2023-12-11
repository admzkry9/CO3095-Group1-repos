package jobAdvertising.tests;

import jobAdvertising.domain.NonAvailableDate;
import jobAdvertising.domain.Schedule;
import jobAdvertising.service.ScheduleService;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ScheduleServiceTest {

    @Test
    public void testDisplaySchedule() {
        ScheduleService scheduleService = new ScheduleService();
        Schedule schedule = new Schedule();
        schedule.setDateWithEmployer("2023-12-01");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        scheduleService.displaySchedule(schedule);
        System.setOut(System.out);

        assertTrue(outContent.toString().contains("Schedule Details:"));
        assertTrue(outContent.toString().contains("Date with Employer: 2023-12-01"));
    }

    @Test
    public void testSetNonAvailableDates() {
        ScheduleService scheduleService = new ScheduleService();

        System.setIn(new ByteArrayInputStream("2023-12-02\n2023-12-03\ndone\n".getBytes()));

        scheduleService.setNonAvailableDates();
        System.setIn(System.in);
        List<NonAvailableDate> nonAvailableDates = scheduleService.getNonAvailableDates();
        assertTrue(nonAvailableDates.size() == 2);
        assertTrue(nonAvailableDates.get(0).getDate().equals(LocalDate.parse("2023-12-02")));
        assertTrue(nonAvailableDates.get(1).getDate().equals(LocalDate.parse("2023-12-03")));
    }
}
