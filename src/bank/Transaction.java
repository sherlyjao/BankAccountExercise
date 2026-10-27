package bank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String type;
    private double amount;
    private LocalDateTime time_stamp;
    private DateTimeFormatter formatter = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.time_stamp = LocalDateTime.now();
    }

    public String toString() {
        return 
            "[type=" + this.type 
            + ", amount=" + this.amount 
            + ", time_stamp=" + this.time_stamp.format(formatter) 
            + "]";
    }

    public double getAmount() {
        return amount;
    }
}