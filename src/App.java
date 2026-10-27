
import bank.BankAccount;
import bank.BankAccountManager;
import bank.session.BankManagerSession;
import bank.session.UserAtmSession;
import bank.ui.UiUtils;

import java.util.Scanner;

/**
 * Runs the command-line ATM interface for a sample bank account.
 */
public class App {
    public boolean isRunning = true;
    private final Scanner scanner = new Scanner(System.in);
    private final BankAccountManager accM1 = new BankAccountManager();

    /** Sets up the initial sample account for testing. */
    // public void setDummyAccount() {
    //     BankAccount acc1 = new SavingsAccount("Test0");
    //     accM1.addAccount(acc1);
    // }

    public void setDummyAccount() throws Exception {
           TestCase testCase = new TestCase();
           testCase.runDummyTestCase(this.accM1);
    }

    public void start() {
        UiUtils.printHeader("Welcome to Surely Bank!");

        while (isRunning) {
            UiUtils.printDivider();
            System.out.println("Actions: "
                + "(1) User ATM mode "
                + "(2) Bank Manager mode "
                + "(3) Exit program");
            UiUtils.printDivider();

            int action = UiUtils.getIntInput(scanner, "Enter action: ");

            switch (action) {
                case 1:
                    userAtmMode();
                    break;

                case 2:
                    bankManagerMode();
                    break;

                case 3:
                    isRunning = false;
                    UiUtils.printExitProgram();
                    break;

                default:
                    UiUtils.printInvalidAction();
                    break;
            }
        }
        scanner.close();
    }

    /**
     * Atm Action.
     */
    public void userAtmMode() {
        int accountId = UiUtils.getIntInput(scanner, "Enter Account ID: ");

        BankAccount account = accM1.getAccount(accountId);

        if (account == null) {
            UiUtils.printAccountNotFound();
            return;
        }

        UserAtmSession userAtmSession = new UserAtmSession(scanner, account);
        userAtmSession.start();
    }

    private void bankManagerMode() {
        BankManagerSession managerSession = new BankManagerSession(scanner, accM1);
        managerSession.start();
    }

    /**
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // set Dummy Account
        App atm = new App();
        atm.setDummyAccount();

        // run atm
        atm.start();
    }
}
