import bank.BankAccount;
import bank.SavingsAccount;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        //Test Cases
        //1. Create a savings account
        BankAccount acc1 = new SavingsAccount("Test0");

        //2. Deposit with valid amount
        System.out.println();
        acc1.deposit(1000.125);

        //2. Deposit with zero amount
        System.out.println();
        acc1.deposit(0);
    }
}
