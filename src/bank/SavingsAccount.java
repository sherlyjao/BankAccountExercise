package bank;

public class SavingsAccount extends BankAccount {
    private String ownerName;

    //constructor
    public SavingsAccount(String ownerName) {
        this.ownerName = ownerName;
    }

    //getter
    public String getOwnerName() {
        return ownerName;
    }
}

