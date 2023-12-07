package jobAdvertising.service;

import java.util.Scanner;
import jobAdvertising.domain.Account;
import org.springframework.stereotype.Service;
@Service
public class AccountService {
    public Account AccountCreate(){
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();
        boolean ValidAns = false;
        System.out.println("Create a Account");
        System.out.println("Create a username : ");
        account.setUsername(scanner.nextLine());

        while(ValidAns == false){

            System.out.println("Create a password");
            String PassAns = scanner.nextLine();
            if(PassAns.length() > 6){
                account.setPassword(PassAns);
                break;
            }
            else if(PassAns.length() <= 6){
                System.out.println("Password is too short");
                continue;
            }
            else{
                System.out.println("Password Unavailable");
                continue;
            }
        }

        while(ValidAns == false){

            System.out.println("Choose a Role : ");
            System.out.println("applicant | employer");
            String RoleAns = scanner.nextLine();
            if(RoleAns.equals("applicant") || RoleAns.equals("employer")){
                System.out.println("Role selected as " + RoleAns);
                account.setRole(RoleAns);
                break;
            }else{
                System.out.println("Invalid Role, Please Try again");
                continue;
            }
        }
        System.out.println("account successfully created");



        return account;
    }

    public Account AccountLogin(){

        Scanner scanner = new Scanner(System.in);
        Account account = new Account();
        boolean ValidAns = false;
        while(ValidAns == false) {

            System.out.println("Login Page");
            System.out.println("Enter Username : ");
            account.setUsername(scanner.nextLine());

            System.out.println("Enter Password : ");
            account.setPassword(scanner.nextLine());

            if (account.getUsername().equals(account.getAdmin_name()) && account.getPassword().equals(account.getAdmin_pass())) {
                System.out.println("Welcome Admin");
                System.out.println();
                break;
            } else{
                System.out.println("Incorrect Username or Password");
                System.out.println("Would you like to create an account instead? Y/N");
                String craccountAns = scanner.nextLine();
                if(craccountAns.equals("Y")){
                    AccountCreate();
                    break;
                }else if(craccountAns.equals("N")) {
                    continue;
                }

            }
        }

        return account;
    }
    public Account AccountCreate(String username, String password, String role) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setRole(role);
        System.out.println("account successfully created");
        return account;
    }

    public Account AccountLogin(String username, String password) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);

        // Existing login logic...

        return account;
    }
}
