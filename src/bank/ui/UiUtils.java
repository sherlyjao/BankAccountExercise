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
                String value = scanner.nextLine().trim();

                if (value.isEmpty()) {
                    throw new IllegalArgumentException("Input can not be empty.\n");
                }


                return Integer.parseInt(value);

            } catch (NumberFormatException e) {
                System.out.println("[Error] Invalid input. "
                        + "Please enter a whole number.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public static double getDoubleInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String value = scanner.nextLine().trim();

                if (value.isEmpty()) {
                    throw new IllegalArgumentException("Input can not be empty.\n");
                }

                return Double.parseDouble(value);
            } catch (NumberFormatException e) {
                System.out.println("[Error] Invalid input. Please enter a valid decimal number.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public static String getStringInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String value = scanner.nextLine().trim();

                if (value.isEmpty()) {
                    throw new IllegalArgumentException("Input can not be empty.\n");
                }

                return value;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
