import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a number:");
            String input = scanner.nextLine();
            int sum = sumOfDigits(input);
            System.out.println("Sum of digits: " + sum);
        }
    }

    private static int sumOfDigits(String number) {
        return number.chars()
                .map(Character::getNumericValue)
                .sum();
    }
}