
import bank.BankAccount;
import bank.BankAccountManager;
import bank.SavingsAccount;
import bank.Transaction;
import java.util.Scanner;

/**
 * Runs the command-line ATM interface for a sample bank account.
 */
public class Atm {
    public boolean isRunning = true;
    private final Scanner scanner = new Scanner(System.in);
    private BankAccountManager accM1 = new BankAccountManager();
    private BankAccount acc1;

    /** Sets up the initial sample account for testing. */
    public void setDummyAccount() {
        acc1 = new SavingsAccount("Test0");
        accM1.addAccount(acc1);
    }

    public void displayUserAccount(BankAccount account) {
        System.out.println();
        System.out.println("================================");
        System.out.println("Sample Account: " + ((SavingsAccount) account).getOwnerName());
        System.out.println("================================");
        System.out.println();
    }

    /** Displays the available ATM actions. */
    public void userActionList(BankAccount account) {
        System.out.println("\nActions: \n(1) Deposit\n(2) Withdraw\n(3) "
                + (account.isFrozen() ? "Unfreeze" : "Freeze")
                + "\n(4) Check Balance\n(5) Get Transaction History\n(6) Logout");
        System.out.println("--------------------------------");
    }

    public void managerActionList() {
        System.out.println("\nActions: \n(1) Create Account\n(2) List All Accounts\n(3) Logout");
        System.out.println("--------------------------------");
    }

    public double userActionInput(String action) {
        System.out.print("Enter " + action + " amount: ");
        return scanner.nextDouble();
    }

    /**
     * Displays the transaction history of an account.
     *
     * @param account the account whose transaction history is displayed
     */
    public void displayTransactionHistory(BankAccount account) {
        if (account.getTransactionHistory().isEmpty()) {
            System.out.println("[Transaction\n[]]");
        } else {
            System.out.println("[Transaction");
            for (Transaction t : account.getTransactionHistory()) {
                System.out.println(t);
            }
            System.out.println("]");
        }
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

        boolean isUserMode = true;

        displayUserAccount(account);
        userActionList(account);

        while (isUserMode) {
            // get user input
            System.out.print("Enter action: ");
            int action = scanner.nextInt();
            System.out.println();

            switch (action) {
                case 1:
                    // double depositAmount = userActionInput("deposit");
                    System.out.println();
                    // account.deposit(depositAmount);

                    break;

                case 2:
                    double withdrawAmount = userActionInput("withdrawal");
                    System.out.println();
                    // account.withdraw(withdrawAmount);

                    break;

                case 3:
                    if (account.isFrozen()) {
                        account.unfreezeAccount();
                    } else {
                        account.freezeAccount();
                    }

                    System.out.println("Account is now " + (account.isFrozen() ? "FROZEN" : "UNFROZEN"));
                    break;

                case 4:
                    System.out.println("Sample Account: " + ((SavingsAccount) account).getOwnerName());
                    acc1.printBalance();
                    break;

                case 5:
                    displayTransactionHistory(account);
                    break;

                case 6:
                    isUserMode = false;
                    System.out.println("\nLogging out of account!");
                    break;

                default:
                    System.out.println("\nInvalid action. Please try again.");
                    break;
            }
        }
    }

    private void bankManagerMode() {
        boolean isManagerMode = true;

        while (isManagerMode) {
            managerActionList();

            // get user input
            System.out.print("Enter action: ");
            int action = scanner.nextInt();
            System.out.println();

            switch (action) {
                case 1:
                    scanner.nextLine();

                    System.out.print("Enter owner name: ");
                    String name = scanner.nextLine();
                    accM1.addAccount(new SavingsAccount(name));
                    break;

                case 2:
                    accM1.listAccounts();
                    break;

                case 3:
                    isManagerMode = false;
                    System.out.println("Logged out from Manager Mode.\n");
                    break;

                default:
                    System.out.println("Invalid option. Try again.\n");
            }
        }
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
