package bank.ui;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UiUtils {
    public static final String DIVIDER_MAJOR = "=============================";
    public static final String DIVIDER_MINOR = "-----------------------------";

    public static void printHeader(String title) {
        System.out.println();
        System.out.println(DIVIDER_MAJOR 
                + "\n" 
                + title 
                + "\n" 
                + DIVIDER_MAJOR);
                
        System.out.println();
    }

    public static void printDivider() {
        System.out.println(DIVIDER_MINOR);
    }

    public static void printLogout() {
        System.out.println("\nLogging out.\n");
    }

    public static void printExitProgram() {
        System.out.println("\nThank you for visiting Surely Bank!\n");
    }

    public static void printInvalidAction() {
        System.out.println("\nInvalid action. Please try again.\n");
    }

    public static void printAccountNotFound() {
        System.out.println("\nAccount does not exist!\n");
    }

    public static int getIntInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = scanner.nextInt();
                scanner.nextLine(); 
                return value;
            } catch (InputMismatchException e) {
                System.out.println("[Error] Invalid input. "
                    + "Please enter a whole number.");
                scanner.nextLine(); 
            }
        }
    }

    public static double getDoubleInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = scanner.nextDouble();
                scanner.nextLine(); 
                return value;
            } catch (InputMismatchException e) {
                System.out.println("[Error] Invalid input. Please enter a valid decimal number.");
                scanner.nextLine(); 
            }
        }
    }
}
