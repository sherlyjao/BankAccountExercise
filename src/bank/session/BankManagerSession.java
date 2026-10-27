package bank.session;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bank.BankAccount;
import bank.BankAccountManager;
import bank.SavingsAccount;
import bank.Transaction;
import bank.ui.UiUtils;

public class BankManagerSession {
    private final Scanner scanner;
    private final BankAccountManager accountManager;

    public  BankManagerSession(Scanner scanner, BankAccountManager accountManager) {
        this.scanner = scanner;
        this.accountManager = accountManager;
    }

    public void displayManagerActionList() {
        System.out.println("\nActions: "
            + "(1) Create Account "
            + "(2) List All Accounts "
            + "(3) See Transaction History "
            + "(4) Logout");
        UiUtils.printDivider();
    }

    public void displayTransactionActionList() {
        System.out.println("\nTransaction Options: "
            + "(1) Normal (Show all) " 
            + "(2) Filter at or above minimum amount) "
            + "(3) Sort by amount ascending "
            + "(4) Logout");
        UiUtils.printDivider();
    }

    public void handleTransactionDisplay() {
        int accountId = UiUtils.getIntInput(scanner, 
                "Enter Account ID to view transactions (-1 to cancel): ");

        if (accountId == -1) {
            return;
        }

        BankAccount account = accountManager.getAccount(accountId);

        if (account == null) {
            UiUtils.printAccountNotFound();
            return;
        }

        List<Transaction> transactions = account.getTransactionHistory();

        if (transactions.isEmpty()) {
            System.out.println("No transactions found in this account.");
            return;
        }

        displayTransactionActionList();
        int transactionAction = UiUtils.getIntInput(scanner, 
                "Choose transaction action: ");

        UiUtils.printDivider();

        switch (transactionAction) {
            case 1:
                transactions.forEach(transaction -> System.out.println(transaction));
                break;
        
            case 2:
                double minimumAmount = UiUtils.getDoubleInput(scanner, 
                        "Enter minimum amount to filter: ");

                List<Transaction> filteredList = 
                    accountManager.filterTransactionsAtOrAbove(minimumAmount, transactions);

                if (filteredList.isEmpty()) {
                    System.out.println("No transactions met this criteria.");
                } else {
                    filteredList.forEach(filteredItem -> System.out.println(filteredItem));
                }

                break;

            case 3:
                List<Transaction> sortedList = accountManager
                    .sortTransactionsByAmount(new ArrayList<>(transactions));
                sortedList.forEach(
                    sortedItem -> System.out.println(sortedItem)
                );

                break;

            case 4:
                System.out.println("\nCancelled viewing transactions.");
                break;

            default:
                UiUtils.printInvalidAction();
                break;
        }
    }

    public void start() {
        boolean isManagerSession = true;

        while (isManagerSession) {
            displayManagerActionList();
            int action = UiUtils.getIntInput(scanner, "Enter action: ");

            switch (action) {
                case 1:
                    scanner.nextLine();

                    System.out.print("Enter owner name: ");
                    String ownerName = scanner.nextLine();
                    accountManager.addAccount(new SavingsAccount(ownerName));
                    break;
            
                case 2:
                    UiUtils.printDivider();
                    accountManager.listAccounts();
                    break;

                case 3:
                    handleTransactionDisplay();
                    break;

                case 4:
                    isManagerSession = false;
                    UiUtils.printLogout();
                    break;

                default:
                    UiUtils.printInvalidAction();
                    break;
            }
        }
    }
}
