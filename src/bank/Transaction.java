package bank;

import java.time.LocalDateTime;

public class Transaction {
    /**
     * Fields
     */
    private String type;
    private double amount;
    private LocalDateTime time_stamp;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.time_stamp = LocalDateTime.now();
    }

    public String toString() {
        return 
            "[type=" + this.type + 
            ",\namount=" + this.amount + 
            ",\ntime_stamp=" + this.time_stamp + "]";
    }
}