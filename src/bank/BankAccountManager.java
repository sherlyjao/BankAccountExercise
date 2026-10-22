package bank;

import java.util.HashMap;

public class BankAccountManager implements Bank {
    HashMap<Integer, BankAccount> accounts;
    private int id;

    public BankAccountManager() {
        this.accounts = new HashMap<>();
        this.id = 0;
    }

    public void addAccount(BankAccount account) {
        if (this.id <= 100) {
            this.accounts.put(id, account);
            this.id += 1;
        } else {
            System.out.println("Bank is full!");
        }
    }

    public BankAccount getAccount(int id) {
        return accounts.get(id);
    }

    public void listAccounts() {
        accounts.forEach((id, account) -> {
            System.out.println(
                "Account ID: " + id + 
                ", Account Name: " + ((SavingsAccount) account).getOwnerName() +
                ", Balance: " + account.getBalance());
        });
    }
}
