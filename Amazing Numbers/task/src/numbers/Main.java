package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a natural number:");
        int number = scanner.nextInt();

        if (number < 1) {
            System.out.println("This number is not natural!");
        } else {
            if (number % 2 == 0) {
                System.out.println("This number is Even.");
            } else {
                System.out.println("This number is Odd.");
            }

            if (number % 10 == 7 || number % 7 == 0) {
                System.out.println("It is a Buzz number.");
            } else {
                System.out.println("It is not a Buzz number.");
            }

            System.out.println("Explanation:");

            if (number % 10 == 7) {
                if (number % 7 == 0) {
                    System.out.println(number + " is divisible by 7 and ends with 7");
                } else {
                    System.out.println(number + " ends with 7");
                }
            } else {
                if (number % 7 == 0) {
                    System.out.println(number + " is divisible by 7");
                } else {
                    System.out.println(number + " is neither divisible by 7 nor does it end with 7");
                }
            }
        }
    }
}
