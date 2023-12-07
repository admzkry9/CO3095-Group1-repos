package jobAdvertising;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import jobAdvertising.service.AccountService;

@Component
public class AccountLoginRunner implements CommandLineRunner {

    private final AccountService accountService;

    public AccountLoginRunner(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws Exception {
        accountService.saveAccountToDatabase(accountService.AccountLogin());
        System.out.println();
    }
}
