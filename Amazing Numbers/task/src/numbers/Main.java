package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Amazing Numbers!");
        System.out.println("""
                                
                Supported requests:
                - enter a natural number to know its properties;
                - enter 0 to exit.
                """);
        System.out.print("Enter a request: ");
        String stringNumber = scanner.nextLine();
        long number;
        while (true) {
            number = Long.parseLong(stringNumber.trim());
            if (printToExit(number)) return;
            if (number < 0) {
                System.out.println("The first parameter should be a natural number or zero.");
            } else {
                System.out.println("Properties of " + number);
                printIsEvenOrOdd(number);
                printIsBuzz(number);
                System.out.println("duck: " + isDuck(number));
                System.out.println("palindromic: " + isPalindrome(stringNumber));
            }
            System.out.print("Enter a request: ");
            stringNumber = scanner.nextLine();
        }
    }

    private static boolean isPalindrome(String number) {
        for (int i = 0; i < number.length() / 2; i++) {
            if (number.charAt(i) != number.charAt(number.length() - 1 - i))
                return false;
        }
        return true;
    }

    private static boolean printToExit(long number) {
        if (number == 0) {
            System.out.println("Goodbye!");
            return true;
        }
        return false;
    }

    private static boolean isDuck(long number) {
        while (number > 0) {
            if (number % 10 == 0) {
                return true;
            }
            number /= 10;
        }
        return false;
    }

    private static void printIsBuzz(long number) {
        boolean isBuzz = number % 10 == 7 || number % 7 == 0;
        System.out.println("buzz: " + isBuzz);
    }

    private static void printIsEvenOrOdd(long number) {
        boolean isEvenOrOdd = number % 2 == 0;
        System.out.println("even: " + isEvenOrOdd);
        System.out.println("odd: " + !isEvenOrOdd);
    }
}
