package jobAdvertising.tests;

import jobAdvertising.domain.Account;
import jobAdvertising.service.AccountService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AccountServiceTest {

    @Test
    public void testAccountCreate() {
        AccountService accountService = new AccountService();

        // Set test values
        String testUsername = "testUser";
        String testPassword = "testPassword";
        String testRole = "applicant";

        // Call the AccountCreate method with test values
        Account account = accountService.AccountCreate();

        // Assert the expected values
        assertEquals(testUsername, account.getUsername());
        assertEquals(testPassword, account.getPassword());
    }
}
