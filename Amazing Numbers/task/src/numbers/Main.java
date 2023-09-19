package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a natural number:");
        String stringNumber = scanner.nextLine();
        int number = Integer.parseInt(stringNumber.trim());

        if (printToNaturalNumber(number)) return;

        System.out.printf("Properties of %s\n", number);

        printIsEvenOrOdd(number);
        printIsBuzz(number);
        System.out.println("duck: " + isDuck(number));
    }

    private static boolean isDuck(int number) {
        while (number > 0) {
            if (number % 10 == 0) {
                return true;
            }
            number /= 10;
        }
        return false;
    }

    private static boolean printToNaturalNumber(int number) {
        if (number < 1) {
            System.out.println("This number is not natural!");
            return true;
        }
        return false;
    }

    private static void printIsBuzz(int number) {
        boolean isBuzz = number % 10 == 7 || number % 7 == 0;
        System.out.println("buzz: " + isBuzz);
    }

    private static void printIsEvenOrOdd(int number) {
        boolean isEvenOrOdd = number % 2 == 0;
        System.out.println("even: " + isEvenOrOdd);
        System.out.println("odd: " + !isEvenOrOdd);
    }
}
