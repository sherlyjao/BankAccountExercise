package bank.session;

import java.util.Scanner;

import bank.BankAccount;
import bank.SavingsAccount;
import bank.Transaction;
import bank.exceptions.AccountFrozenException;
import bank.exceptions.InsufficientFundsException;
import bank.exceptions.InvalidAmountException;
import bank.ui.UiUtils;

public class UserAtmSession {
    private final Scanner scanner;
    private final BankAccount account;

    public UserAtmSession(Scanner scanner, BankAccount account) {
        this.scanner = scanner;
        this.account = account;
    }

    public void displayUserAccount() {
        UiUtils.printHeader("Account " 
            + ((SavingsAccount) account).getOwnerName());
    }

    public void displayUserActionList() {
        System.out.println("\nActions: \n(1) Deposit\n(2) Withdraw\n(3) "
                + (account.isFrozen() ? "Unfreeze" : "Freeze")
                + "\n(4) Check Balance\n(5) Get Transaction History\n(6) Logout");
        UiUtils.printDivider();
    }

    public double userActionInput(String action) {
        return UiUtils.getDoubleInput(scanner, 
            "Enter " + action + " amount: ");
    }

    public void start() {
        displayUserAccount();
        boolean isUserSession = true;

        while (isUserSession) {
            displayUserActionList();

            int action = UiUtils.getIntInput(scanner, "Enter action: ");

            switch (action) {
                case 1:
                    try {
                        double depositAmount = userActionInput("deposit");
                        System.out.println();
                        account.deposit(depositAmount);
                    } catch (AccountFrozenException 
                            | InvalidAmountException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                
                case 2:
                    try {
                        double withdrawAmount = userActionInput("withdrawal");
                        System.out.println();
                        account.withdraw(withdrawAmount);
                    } catch (AccountFrozenException
                            | InvalidAmountException
                            | InsufficientFundsException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 3: 
                    if (account.isFrozen()) {
                        account.unfreezeAccount();
                    } else {
                        account.freezeAccount();
                    }

                    System.out.println("Account is now " 
                        + (account.isFrozen() ? "FROZEN" : "UNFROZEN"));
                    
                    break;

                case 4:
                    System.out.println("Sample Account: " 
                        + ((SavingsAccount) account).getOwnerName());
                    account.printBalance();
                    break;

                case 5:
                    displayTransactionHistory(account);
                    break;

                case 6:
                    isUserSession = false;
                    UiUtils.printLogout();
                    break;

                default:
                    UiUtils.printInvalidAction();
                    break;            
            }
        }
    }

    public void displayTransactionHistory(BankAccount account) {
        if (account.getTransactionHistory().isEmpty()) {
            System.out.println("[Transaction\n[-]]");
        } else {
            System.out.println("[Transaction");
            for (Transaction t : account.getTransactionHistory()) {
                System.out.println(t);
            }
            System.out.println("]");
        }
    }
}
