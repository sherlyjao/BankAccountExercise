package bank.session;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bank.BankAccount;
import bank.BankAccountManager;
import bank.SavingsAccount;
import bank.Transaction;

public class BankManagerSession {
    private final Scanner scanner;
    private final BankAccountManager accountManager;

    public  BankManagerSession(Scanner scanner, BankAccountManager accountManager) {
        this.scanner = scanner;
        this.accountManager = accountManager;
    }

    public void displayManagerActionList() {
        System.out.println("\nActions: (1) Create Account (2) List All Accounts (3) See Transaction History (4) Logout");
        System.out.println("--------------------------------");
    }

    public void displayTransactionActionList() {
        System.out.println("\nTransaction Options:  (1) Normal (Show all) (2) Filter at or above minimum amount) (3) Sort by amount ascending (4) Logout");
        System.out.println("--------------------------------");
    }

    public void handleTransactionDisplay() {
        System.out.println("Enter Account ID to view transactions (-1 to cancel): ");
        int accountId = scanner.nextInt();

        if (accountId == -1) {
            return;
        }

        BankAccount account = accountManager.getAccount(accountId);

        if (account == null) {
            System.out.println("Account does not exist!");
            return;
        }

        List<Transaction> transactions = account.getTransactionHistory();

        if (transactions.isEmpty()) {
            System.out.println("No transactions found in this account.");
            return;
        }

        displayTransactionActionList();
        System.out.print("Choose transaction action: ");
        int transactionAction = scanner.nextInt();
        System.out.println();

        switch (transactionAction) {
            case 1:
                transactions.forEach(transaction -> System.out.println(transaction));
                break;
        
            case 2:
                System.out.print("Enter minimum amount to filter: ");
                double minimumAmount = scanner.nextDouble();

                List<Transaction> filteredList = accountManager.filterTransactionsAtOrAbove(minimumAmount, transactions);

                if (filteredList.isEmpty()) {
                    System.out.println("No transactions met this criteria.");
                } else {
                    filteredList.forEach(filteredItem -> System.out.println(filteredItem));
                }

            case 3:
                List<Transaction> sortedList = accountManager.sortTransactionsByAmount(new ArrayList<>(transactions));
                sortedList.forEach(sortedItem -> System.out.println(sortedItem));
                break;

            case 4:
                System.out.println("\nCancelled viewing transactions.");
                break;

            default:
                System.out.println("\nInvalid action. Please try again.");
                break;
        }
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
                    handleTransactionDisplay();
                    break;

                case 4:
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
