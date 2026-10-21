import bank.BankAccount;
import bank.SavingsAccount;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        //initial account for test
        BankAccount acc1 = new SavingsAccount("Test0");

        //GUI
        System.out.println();
        System.out.println("================================");
        System.out.println("Sample Account: " + ((SavingsAccount) acc1).getOwnerName());
        System.out.println("================================");
        System.out.println();

        
        while (isRunning) {
            System.out.println("Actions: (1) Deposit (2) Withdraw (3) " + (acc1.isFrozen() ? "Unfreeze" : "Freeze") + " (5) Check Balance (6) Exit");
            System.out.println("--------------------------------");

            //get user input
            System.out.print("Enter action: ");
            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();

                    if (acc1.isFrozen()) {
                        System.out.println("Account is FROZEN. Unable to transact.");
                    } else if (depositAmount > 0) {
                        acc1.deposit(depositAmount);
                        System.out.printf("Amount deposited: $%.2f%n", depositAmount);
                    } else {
                        System.out.println("Invalid amount. Must be greater than 0");
                    }
                    
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
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
}
