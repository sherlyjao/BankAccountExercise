
import bank.BankAccount;
import bank.SavingsAccount;
import java.util.Scanner;

/**
 * Runs the command-line ATM interface for a sample bank account.
 */
public class Atm {
    public boolean isRunning = true;
    private final Scanner scanner = new Scanner(System.in);
    private BankAccount acc1;

    /** Sets up the initial sample account for testing. */
    public void setDummyAccount() {
        acc1 = new SavingsAccount("Test0");

        // GUI
        System.out.println();
        System.out.println("================================");
        System.out.println("Sample Account: " + ((SavingsAccount) acc1).getOwnerName());
        System.out.println("================================");
        System.out.println();
    }

    /** Displays the available ATM actions. */
    public void actionList() {
        System.out.println("Actions: (1) Deposit (2) Withdraw (3) "
                + (acc1.isFrozen() ? "Unfreeze" : "Freeze")
                + " (4) Check Balance (5) Exit");
        System.out.println("--------------------------------");
    }

    public double actionInput(String action) {
        System.out.print("Enter " + action + " amount: ");
        return scanner.nextDouble();
    }

    /**
     * Atm Action.
     */
    public void atmAction() {
        while (isRunning) {
            actionList();

            // get user input
            System.out.print("Enter action: ");
            int action = scanner.nextInt();
            System.out.println();

            switch (action) {
                case 1:
                    double depositAmount = actionInput("deposit");
                    System.out.println();
                    acc1.deposit(depositAmount);

                    break;

                case 2:
                    double withdrawAmount = actionInput("withdrawal");
                    System.out.println();
                    acc1.withdraw(withdrawAmount);

                    break;

                case 3:
                    if (acc1.isFrozen()) {
                        acc1.unfreezeAccount();
                    } else {
                        acc1.freezeAccount();
                    }

                    System.out.println("Account is now " + (acc1.isFrozen() ? "FROZEN" : "UNFROZEN"));
                    break;

                case 4:
                    System.out.println("Sample Account: " + ((SavingsAccount) acc1).getOwnerName());
                    acc1.printBalance();
                    break;

                case 5:
                    isRunning = false;
                    System.out.println("Thank you for visiting Surely Bank!");
                    break;

                default:
                    System.out.println("Invalid action. Please try again.");
                    break;
            }

            System.out.println("================================");
            System.out.println();
        }

        scanner.close();
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
        atm.atmAction();
    }
}
