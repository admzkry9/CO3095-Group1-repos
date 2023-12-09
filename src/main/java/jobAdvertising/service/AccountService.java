package jobAdvertising.service;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import jobAdvertising.domain.Account;
import jobAdvertising.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AccountService {

    private AccountRepo accountRepo;


    // Add a default constructor for better testability
    public AccountService() {
        // Default constructor
    }

    @Autowired
    public AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    // Add a setter for accountRepo for better testability
    public void setAccountRepo(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    public Account AccountCreate() {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();
        boolean validAns = false;
        System.out.println("Create an Account");
        System.out.println("Create a username: ");
        account.setUsername(scanner.nextLine());

        while (!validAns) {
            System.out.println("Create a password");
            String passAns = scanner.nextLine();
            if (passAns.length() > 6) {
                account.setPassword(passAns);
                break;
            } else if (passAns.length() <= 6) {
                System.out.println("Password is too short");

            } else {
                System.out.println("Password Unavailable");

            }
        }

        while (!validAns) {
            System.out.println("Choose a Role: ");
            System.out.println("applicant | employer");
            String roleAns = scanner.nextLine();

            if (roleAns.equals("applicant")) {
                System.out.println("Role selected as " + roleAns);
                account.setRole(roleAns);
                // Ask for location for applicants
                System.out.println("Enter your location: ");
                String location = scanner.nextLine();
                account.setLocation(location);

                break;
            } else if (roleAns.equals("employer")) {
                System.out.println("Role selected as " + roleAns);
                account.setRole(roleAns);
                break;
            } else {
                System.out.println("Invalid Role, Please Try again");
            }

        }

        // Save account to the database
        saveAccountToDatabase(account);

        System.out.println("Account successfully created");
        return account;
    }
    
    public Account AccountLogin() {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();
        boolean validAns = false;

        while (!validAns) {
            System.out.println("Login Page");
            System.out.println("Enter Username : ");
            account.setUsername(scanner.nextLine());

            System.out.println("Enter Password : ");
            account.setPassword(scanner.nextLine());

            if (account.getUsername().equals(account.getAdmin_name()) && account.getPassword().equals(account.getAdmin_pass())) {
                System.out.println("Welcome Admin");
                System.out.println();
                break;
            } else {
                System.out.println("Incorrect Username or Password");
                System.out.println("Would you like to create an account instead? Y/N");
                String craccountAns = scanner.nextLine();
                if (craccountAns.equals("Y")) {
                    // Use the created account and save it to the database
                    Account createdAccount = AccountCreate();
                    saveAccountToDatabase(createdAccount);
                    break;
                } else if (craccountAns.equals("N")) {
                    System.out.println("Going back to login");
                } else{
                    System.out.println("Invalid answer");
                }
            }
        }

        return account;
    }

    public void saveAccountToDatabase(Account account) {
        accountRepo.save(account);
        System.out.println("Account successfully saved to the database.");
    }
}
