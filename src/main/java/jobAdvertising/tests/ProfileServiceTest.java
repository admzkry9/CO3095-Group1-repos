package jobAdvertising.tests;

import jobAdvertising.domain.Profile;
import jobAdvertising.service.ProfileService;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProfileServiceTest {
    @Test
    public void testCreateProfile() {
        String userInput = "John\n123456789\nY\nimage.jpg\nY\nresume.pdf\n";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        ProfileService profileService = new ProfileService();
        Profile profile = profileService.createProfile();

        System.setIn(System.in);

        assertNotNull(profile);
        assertEquals("John", profile.getName());
        assertEquals(123456789, profile.getContactNumber());
        assertEquals("image.jpg", profile.getImagePath());
        assertEquals(null, profile.getResumeData());
    }

    @Test
    public void testDisplayProfile() {

        Profile profile = new Profile();
        profile.setName("Jane");
        profile.setContactNumber(987654321);
        profile.setImagePath("profile.jpg");
        profile.setResumeData(null);


        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));


        ProfileService profileService = new ProfileService();
        profileService.displayProfile(profile);
        System.setOut(System.out);
        String expectedOutput = "Profile Details:\n" +
                "Name: Jane\n" +
                "Contact Number: 987654321\n" +
                "Image Path: profile.jpg\n" +
                "No resume data available.\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
