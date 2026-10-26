package bank.session;

import java.util.Scanner;

import bank.BankAccountManager;
import bank.SavingsAccount;

public class BankManagerSession {
    private final Scanner scanner;
    private final BankAccountManager accountManager;

    public  BankManagerSession(Scanner scanner, BankAccountManager accountManager) {
        this.scanner = scanner;
        this.accountManager = accountManager;
    }

    public void displayManagerActionList() {
        System.out.println("\nActions: \n(1) Create Account\n(2) List All Accounts\n(3) Logout");
        System.out.println("--------------------------------");
    }

    public void start() {
        boolean isManagerSession = true;

        while (isManagerSession) {
            displayManagerActionList();

            System.out.println("Enter action: ");
            int action = scanner.nextInt();
            System.out.println();

            switch (action) {
                case 1:
                    scanner.nextLine();

                    System.out.print("Enter owner name: ");
                    String ownerName = scanner.nextLine();
                    accountManager.addAccount(new SavingsAccount(ownerName));
                    break;
            
                case 2:
                    accountManager.listAccounts();
                    break;

                case 3:
                    isManagerSession = false;
                    System.out.println("Logged out from Manager Mode.\n");
                    break;

                default:
                    System.out.println("Invalid option. Try again.\n");
                    break;
            }
        }
    }
}
