
import bank.BankAccount;
import bank.BankAccountManager;
import bank.session.BankManagerSession;
import bank.session.UserAtmSession;
import bank.ui.UiUtils;
import java.util.Scanner;

public class App {
    public boolean isRunning = true;
    private final Scanner scanner = new Scanner(System.in);
    private final BankAccountManager accM1 = new BankAccountManager();

    // Setting up dummy account Test0 with test cases
    public void setDummyAccount() throws Exception {
        TestCase testCase = new TestCase();
        testCase.runDummyTestCase(this.accM1);
    }

    /** Starts the command-line ATM interface. */
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

    /** Initializes the sample account and starts the ATM interface.
     * @param args command-line arguments
     * @throws Exception if the sample account cannot be initialized
     */
    public static void main(String[] args) throws Exception {
        // set Dummy Account
        App atm = new App();
        atm.setDummyAccount();

        // run atm
        atm.start();
    }
}
