package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                                
                Welcome to Amazing Numbers!
                                
                Supported requests:
                - enter a natural number to know its properties;
                - enter two natural numbers to obtain the properties of the list:
                  * the first parameter represents a starting number;
                  * the second parameter shows how many consecutive numbers are to be processed;
                - separate the parameters with one space;
                - enter 0 to exit.
                """);
        System.out.print("Enter a request: ");
        String stringNumber = scanner.nextLine();
        System.out.println();
        String[] spliter = stringNumber.trim().split(" ");
        long number = -1;
        while (true) {
            try {
                number = Long.parseLong(spliter[0]);
            } catch (Exception e) {
                System.out.print("");
            }
            if (printToExit(number)) return;
            if (number < 0) {
                System.out.println("The first parameter should be a natural number or zero.");
                System.out.println();
            } else if (spliter.length == 1) {
                try {
                    number = Long.parseLong(spliter[0]);
                    singleMetod(number);
                } catch (Exception e) {
                    System.out.println("The first parameter should be a natural number or zero.");
                    System.out.println();
                }
            } else {
                if (Integer.parseInt(spliter[1]) < 1) {
                    System.out.println("The second parameter should be a natural number.");
                }
                int secondParam = Integer.parseInt(spliter[1]);
                String line;
                for (int i = 0; i < secondParam; i++) {
                    line = String.valueOf(doubleMetod(number + i));
                    System.out.println(line);
                }
                System.out.println();
            }
            System.out.print("Enter a request: ");
            stringNumber = scanner.nextLine();
            spliter = stringNumber.trim().split(" ");

        }
    }

    private static StringBuilder doubleMetod(long number) {
        String stringNumber = String.valueOf(number);
        StringBuilder complexText = new StringBuilder();

        complexText.append(stringNumber);
        complexText.append(" is ");
        if (isBuzz(number)) complexText.append("buzz ");
        if (isDuck(number)) complexText.append("duck ");
        if (isPalindrome(stringNumber)) complexText.append("palindromic ");
        if (isGapful(stringNumber)) complexText.append("gapful ");
        if (isEvenOrOdd(number)) complexText.append("even ");
        if (!isEvenOrOdd(number)) complexText.append("odd ");
        return complexText;
    }

    private static void singleMetod(long number) {
        String stringNumber = String.valueOf(number);

        System.out.println("Properties of " + number);
        System.out.println("buzz: " + isBuzz(number));
        System.out.println("duck: " + isDuck(number));
        System.out.println("palindromic: " + isPalindrome(stringNumber));
        System.out.println("gapful: " + isGapful(stringNumber));
        System.out.println("even: " + isEvenOrOdd(number));
        System.out.println("odd: " + !isEvenOrOdd(number));
        System.out.println();

    }

    private static boolean isGapful(String stringNumber) {
        long number = Long.parseLong(stringNumber);
        int divider = 0;
        if (number > 99) {
            int first = stringNumber.charAt(0) - 48;
            int last = stringNumber.charAt(stringNumber.length() - 1) - 48;
            divider = first * 10 + last;
            return number % divider == 0;
        }
        return false;

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
            System.out.println();
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

    private static boolean isBuzz(long number) {
        return number % 10 == 7 || number % 7 == 0;
    }

    private static boolean isEvenOrOdd(long number) {
        return number % 2 == 0;
    }
}
