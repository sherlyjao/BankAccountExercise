package bank;

public class BankAccount {
    private double balance;
    public boolean isFrozen;

    //constructor
    public BankAccount() {
        this.balance = 0.00;
        this.isFrozen = false;
    }

    //methods
    public void deposit(double amount) {
        if (!isFrozen && amount > 0) {
            this.balance += amount;
        } else if (isFrozen) {
            System.out.println("This account is frozen. Cannot deposit.");
        } else {
            System.out.println("Please deposit a positive amount.");
        }
    }

    public void withdraw(double amount) {
        if (!isFrozen && amount > 0 && amount <= balance) {
            this.balance -= amount;
        } else if (isFrozen) {
            System.out.println("This account is frozen. Cannot withdraw.");
        } else if (amount <= 0) {
            System.out.println("Please withdraw a positive amount.");
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public void freezeAccount() {
        this.isFrozen = true;
    }

    public void unfreezeAccount() {
        this.isFrozen = false;
    }

    public boolean isFrozen() {
        return this.isFrozen;
    }
}
 