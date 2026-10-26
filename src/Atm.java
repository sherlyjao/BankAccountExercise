
import bank.BankAccount;
import bank.BankAccountManager;
import bank.SavingsAccount;
import bank.session.BankManagerSession;
import bank.session.UserAtmSession;

import java.util.Scanner;

/**
 * Runs the command-line ATM interface for a sample bank account.
 */
public class Atm {
    public boolean isRunning = true;
    private final Scanner scanner = new Scanner(System.in);
    private final BankAccountManager accM1 = new BankAccountManager();

    /** Sets up the initial sample account for testing. */
    public void setDummyAccount() {
        BankAccount acc1 = new SavingsAccount("Test0");
        accM1.addAccount(acc1);
    }

    public void start() {
        while (isRunning) {
            System.out.println("================================");
            System.out.println("Welcome to Surely Bank!");
            System.out.println("================================");

            System.out.println("Actions: \n(1) User ATM mode\n(2) Bank Manager mode\n(3) Exit program");
            System.out.println("--------------------------------");

            System.out.print("Enter action: ");
            int action = scanner.nextInt();
            System.out.println();

            switch (action) {
                case 1:
                    userAtmMode();
                    break;

                case 2:
                    bankManagerMode();
                    break;

                case 3:
                    isRunning = false;
                    System.out.println("\nThank you for visiting Surely Bank!");
                    break;

                default:
                    System.out.println("\nInvalid action. Please try again.");
                    break;
            }
        }
        System.out.println("================================");
        System.out.println();

        scanner.close();
    }

    /**
     * Atm Action.
     */
    public void userAtmMode() {
        System.out.print("Enter Account ID: ");
        int accountId = scanner.nextInt();
        scanner.nextLine();

        BankAccount account = accM1.getAccount(accountId);

        if (account == null) {
            System.out.println("Account not found!\n");
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
        Atm atm = new Atm();
        atm.setDummyAccount();

        // run atm
        atm.start();
    }
}
