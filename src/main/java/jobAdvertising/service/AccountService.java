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

        System.out.println("Create a username : ");
        account.setUsername(scanner.nextLine());

        System.out.println("Create a password : ");
        account.setPassword(scanner.nextLine());

        while(ValidAns == false){

            System.out.println("Create a username : ");
            String RoleAns = scanner.nextLine();
            if(RoleAns.equals("applicant") || RoleAns.equals("employer")){
                account.setRole(RoleAns);
                ValidAns = true;
            }else{
                System.out.println("Invalid Role, Please Try again");
                continue;
            }
        }



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
                System.out.print("Welcome Admin");
                break;
            } else{
                System.out.print("Incorrect Username or Password");
                continue;

            }
        }

        return account;
    }
}
