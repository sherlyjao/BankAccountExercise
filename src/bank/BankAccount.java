package bank;

public class BankAccount {
    private double balance;

    public boolean isFrozen;
    public String invalidAmountMessage = "Invalid amount. Must be greater than 0";
    public String inssufficientBalanceMessage = "Insufficient balance.";
    public String accountStatusMessage = "Account is " + (isFrozen ? "FROZEN" : "UNFROZEN") + ". Unable to transact.";

    // print results
    public void printAction(double amount, String action) {
        System.out.printf("Amount " + action + ": %.2f%n", amount);
    }

    public void printBalance() {
        System.out.printf("Current balance: %.2f%n", this.getBalance());
    }



    // constructor
    public BankAccount() {
        this.balance = 0.00;
        this.isFrozen = false;
    }

    // methods
    public void deposit(double amount) {
        // if (!isFrozen && amount > 0) {
        // this.balance += amount;
        // }

        if (isFrozen) {
            System.out.println(accountStatusMessage);
        } else if (amount <= 0) {
            printAction(amount, "deposited");
            System.out.println(invalidAmountMessage);
        } else {
            this.balance += amount;
            printAction(amount, "deposited");
            printBalance();
        }
    }

    public void withdraw(double amount) {
        // if (!isFrozen && amount > 0) {
        // if (amount > this.balance) {
        // System.out.println(inssufficientBalanceMessage);
        // } else {
        // this.balance -= amount;
        // }
        // }

        if (isFrozen) {
            System.out.println(accountStatusMessage);
        } else if (amount > this.balance) {
            System.out.println(inssufficientBalanceMessage);
        } else {
            this.balance -= amount;
            printAction(amount, "withdrawn");
        }
    }

    public void freezeAccount() {
        this.isFrozen = true;
        System.out.println("Account is now FROZEN.");
    }

    public void unfreezeAccount() {
        this.isFrozen = false;
        System.out.println("Account is now UNFROZEN.");
    }

    // getters
    public double getBalance() {
        return this.balance;
    }

    public boolean isFrozen() {
        return this.isFrozen;
    }
}
