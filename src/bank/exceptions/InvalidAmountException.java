package bank.exceptions;

/**
 * Indicates that an invalid monetary amount was provided.
 */
public class InvalidAmountException extends Exception {
    private String message;

    public InvalidAmountException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
