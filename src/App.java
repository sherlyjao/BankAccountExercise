import bank.BankAccount;
import bank.SavingsAccount;

/**
 App.
*/
public class App {
    /**
     * Runs bank account test cases.
     *
     * @param args command-line arguments
     * @throws Exception if an error occurs during a bank account operation
     */
    public static void main(String[] args) throws Exception {

        //==== TEST CASES ====
        //1. Create a savings account
        System.out.println();
        BankAccount acc1 = new SavingsAccount("Test0");
        System.out.println("Sample Account: " + ((SavingsAccount) acc1).getOwnerName());

        //2. Deposit with valid amount
        System.out.println();
        acc1.deposit(1000.125);

        //3. Deposit with zero amount
        System.out.println();
        acc1.deposit(0);

        //4. Deposit with negative amount
        System.out.println();
        acc1.deposit(-500);

        //5. Withdraw with sufficient funds
        System.out.println();
        acc1.withdraw(500);

        //6. Withdraw with insufficient funds
        System.out.println();
        acc1.withdraw(1500);

        //7. Withdraw with negative amount
        System.out.println();
        acc1.withdraw(-100);

        //8. Deposit when account is frozen
        System.out.println();
        acc1.freezeAccount();
        acc1.deposit(11500);

        //9. Withdraw when account is frozen
        System.out.println();
        acc1.withdraw(500);

        //10. Unfreeze account and withdraw
        System.out.println();
        acc1.unfreezeAccount();
        acc1.withdraw(100);

        System.out.println();
    }
}
