import bank.BankAccount;
import bank.BankAccountManager;
import bank.SavingsAccount;

public class TestCase {

    public void runDummyTestCase(BankAccountManager accM1) throws Exception {
        BankAccount acc1 = new SavingsAccount("Test0");
        accM1.addAccount(acc1);

        // == Adding Dummy Transactions ==
        //Deposit with valid amount
        System.out.println();
        acc1.deposit(1000.125);

        // Withdraw with sufficient funds
        System.out.println();
        acc1.withdraw(500);

        acc1.withdraw(100);
    }
}
