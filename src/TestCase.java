import bank.BankAccount;
import bank.BankAccountManager;
import bank.SavingsAccount;
import bank.Transaction;

/**
 * App.
 */
public class TestCase {

    public void runDummyTestCase(BankAccountManager accM1) throws Exception {
        BankAccount acc1 = new SavingsAccount("Test0");
        accM1.addAccount(acc1);

        // 2. Deposit with valid amount
        System.out.println();
        acc1.deposit(1000.125);

        // 3. Deposit with zero amount
        // System.out.println();
        // acc1.deposit(0);

        // 4. Deposit with negative amount
        // System.out.println();
        // acc1.deposit(-500);

        // 5. Withdraw with sufficient funds
        System.out.println();
        acc1.withdraw(500);

        // 6. Withdraw with insufficient funds
        // System.out.println();
        // acc1.withdraw(1500);

        // 7. Withdraw with negative amount
        // System.out.println();
        // acc1.withdraw(-100);

        // 8. Deposit when account is frozen
        // System.out.println();
        // acc1.freezeAccount();
        // acc1.deposit(11500);

        // 9. Withdraw when account is frozen
        // System.out.println();
        // acc1.withdraw(500);

        // 10. Unfreeze account and withdraw
        // System.out.println();
        // acc1.unfreezeAccount();
        acc1.withdraw(100);

        // ==== TEST CASES Exercise 2 ====
        // > Create a savings account
        // System.out.println();
        // BankAccount acc1 = new SavingsAccount("Test0");
        // System.out.println("Sample Account: " + ((SavingsAccount)
        // acc1).getOwnerName());

        // 1. Display transaction historu of acc1.
        // System.out.println("[Transaction");
        // for (Transaction t : acc1.getTransactionHistory()) {
        //     System.out.println(t);
        // }
        // System.out.println("]");

        // 2. Create a Bank Account Manager
        // BankAccountManager accM1 = new BankAccountManager();

        // 3. Add acc1 under the bankAccount Manager
        // accM1.addAccount(acc1);

        // 4. Create a new account under Bank Account Manager
        // accM1.addAccount(new SavingsAccount("Test1"));

        // 5. List all the created account under Bank Account Manager
        // accM1.listAccounts();

        // System.out.println();
    }
}
