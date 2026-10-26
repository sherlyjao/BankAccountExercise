package bank;

import java.util.ArrayList;
import java.util.List;

import bank.exceptions.AccountFrozenException;

/**
 * Bank Account class.
 */
public class BankAccount {
  private double balance;
  private boolean isFrozen;

  private List<Transaction> transactionHistory;

  private String INVALID_AMOUNT_MESSAGE = "Invalid amount. Must be greater than 0";
  private String INSUFFICIENT_BALANCE_MESSAGE = "Insufficient balance.";
  private String FROZEN_ACCOUNT_MESSAGE = "Account is FROZEN. Unable to transact.";

  public BankAccount() {
    this.balance = 0.00;
    this.isFrozen = false;
    this.transactionHistory = new ArrayList<>();
  }

  public void freezeAccount() {
    this.isFrozen = true;
  }

  public void unfreezeAccount() {
    this.isFrozen = false;
  }

  public double getBalance() {
    return this.balance;
  }

  public boolean isFrozen() {
    return this.isFrozen;
  }

  public void checkStatus() throws AccountFrozenException {
    if (this.isFrozen) {
      throw new AccountFrozenException(FROZEN_ACCOUNT_MESSAGE);
    }
  }

  /**
   * 
   * @param amount
   */
  public void deposit(double amount) throws AccountFrozenException {
    String actionText = "Deposit";

    // if (this.isFrozen()) {
    // System.out.println(accountStatusMessage());
    // return;

    // }

    checkStatus();

    if (amount <= 0) {
      printAction(amount, actionText);
      System.out.println(INVALID_AMOUNT_MESSAGE);

    } else {
      this.balance += amount;
      this.transactionHistory.add(new Transaction(actionText, amount));

      printAction(amount, actionText);
      printBalance();
    }
  }

  public void withdraw(double amount) {
    String actionText = "Withdraw";

    // if (this.isFrozen()) {
    // System.out.println(accountStatusMessage());
    // return;

    // }

    if (amount > this.balance) {
      printAction(amount, actionText);
      System.out.println(INSUFFICIENT_BALANCE_MESSAGE);
      printBalance();

    } else if (amount <= 0) {
      printAction(amount, actionText);
      System.out.println(INVALID_AMOUNT_MESSAGE);

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

  // print results
  public void printAction(double amount, String action) {
    System.out.printf("Amount " + action + ": %.2f%n", amount);
  }

  public void printBalance() {
    System.out.printf("Current balance: %.2f%n", this.getBalance());
  }
}