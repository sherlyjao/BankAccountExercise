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
        } 
    }

    public void withdraw(double amount) {
        if (!isFrozen && amount > 0) {
            if (amount > this.balance) {
                System.out.println("Insufficient balance.");
            } else {
                this.balance -= amount;
            }
        }
    }
        
    public void freezeAccount() {
        this.isFrozen = true;
    }

    public void unfreezeAccount() {
        this.isFrozen = false;
    }

    //getters
    public double getBalance() {
        return this.balance;
    }

    public boolean isFrozen() {
        return this.isFrozen;
    }
}
 