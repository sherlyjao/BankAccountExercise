package bank.exceptions;

/**
 * Thrown when an account has insufficient funds for a requested operation.
 */
public class InsufficientFundsException extends Exception {
    /**
     * The detail message explaining the insufficient funds condition.
     */
    private String message;

    public InsufficientFundsException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}