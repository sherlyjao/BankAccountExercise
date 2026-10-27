package bank;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Manages the bank accounts stored by the bank.
 */
public class BankAccountManager implements Bank {
  private HashMap<Integer, BankAccount> accounts;
  private int id;

  /**
   * Constructs a new {@code BankAccountManager} with no accounts and an initial ID of zero.
   */
  public BankAccountManager() {
    this.accounts = new HashMap<>();
    this.id = 0;
  }

  /**
   * Adds an account to the bank.
   *
   * @param account the account to add
   */
  public void addAccount(BankAccount account) {
    if (this.id <= 100) {
      this.accounts.put(id, account);
      System.out.println("Account added successfully with ID: " + this.id);

      this.id += 1;
    } else {
      System.out.println("Bank is full!");
    }
  }

  /**
   * Retrieves an account by its ID.
   *
   * @param id the account ID
   * @return the matching account, or {@code null} if no account has that ID
   */
  public BankAccount getAccount(int id) {
    return accounts.get(id);
  }

  /**
   * Lists all accounts managed by the bank.
   */
  public void listAccounts() {
    accounts.forEach((id, account) -> {
      String ownerName = (account instanceof SavingsAccount)
          ? ((SavingsAccount) account).getOwnerName()
          : "N/A";

      System.out.printf("Account ID: %s, Account Name: %s, Balance: %.2f%n",
          id, ownerName, account.getBalance());
    });
  }

  public List<Transaction> filterTransactionsAtOrAbove(
    double amount, 
    List<Transaction> txList
  ) {
    
    return txList
        .stream()
        .filter(transaction -> transaction.getAmount() >= amount)
        .collect(java.util.stream.Collectors.toList());
  }

  public List<Transaction> sortTransactionsByAmount(List<Transaction> txList) {
    return txList.stream()
      .filter(transaction -> transaction != null)
      .sorted(Comparator.comparingDouble(Transaction::getAmount))
      .collect(Collectors.toList());
  }
}
