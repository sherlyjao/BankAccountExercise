package bank;

import java.util.ArrayList;
import java.util.List;

/**
 * Bank Account.
 */
public class BankAccount {
    private double balance;
    public boolean isFrozen;

    public String invalidAmountMessage = "Invalid amount. Must be greater than 0";
    public String inssufficientBalanceMessage = "Insufficient balance.";
    public String accountStatusMessage = "Account is " + (isFrozen ? "UNFROZEN" : "FROZEN") + ". Unable to transact.";

    private List<Transaction> transactionHistory;

    
    // constructor
    public BankAccount() {
        this.balance = 0.00;
        this.isFrozen = false;
        this.transactionHistory = new ArrayList<>();
    }

    /**
     * 
     * @param amount
    */
   public void deposit(double amount) {
       String actionText = "Deposit";
       
       if (isFrozen) {
           System.out.println(accountStatusMessage);
           
        } else if (amount <= 0) {
            printAction(amount, actionText);
            System.out.println(invalidAmountMessage);
            
        } else {
            this.balance += amount;
            this.transactionHistory.add(new Transaction(actionText, amount));
            
            printAction(amount, actionText);
            printBalance();
        }
    }

    public void withdraw(double amount) {
        String actionText = "Withdraw";

        if (isFrozen) {
            System.out.println(accountStatusMessage);
            
        } else if (amount > this.balance) {
            printAction(amount, actionText);
            System.out.println(inssufficientBalanceMessage);
            printBalance();

        } else if (amount <= 0) {
            printAction(amount, actionText);
            System.out.println(invalidAmountMessage);
            
        } else {
            this.balance -= amount;
            this.transactionHistory.add(new Transaction(actionText, amount));

            printAction(amount, actionText);
            printBalance();
        }
    }

    public List<Transaction> getTransactionHistory() {
        return this.transactionHistory;
    }
    
    public void freezeAccount() {
        this.isFrozen = true;
    }
    
    public void unfreezeAccount() {
        this.isFrozen = false;
    }
    
    // getters
    public double getBalance() {
        return this.balance;
    }
    
    public boolean isFrozen() {
        return this.isFrozen;
    }
    
    // print results
    public void printAction(double amount, String action) {
        System.out.printf("Amount " + action + ": %.2f%n", amount);
    }

    public void printBalance() {
        System.out.printf("Current balance: %.2f%n", this.getBalance());
    }
}