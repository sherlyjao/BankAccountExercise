package bank.exceptions;

/**
 * Thrown when an operation cannot be performed on a frozen bank account.
 */
public class AccountFrozenException extends Exception {
  private String message;

  public AccountFrozenException(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
