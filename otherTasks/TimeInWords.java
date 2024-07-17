import java.util.Scanner;

public class TimeInWords {
    private static final String[] NUMBERS = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
            "twenty", "twenty-one", "twenty-two", "twenty-three", "twenty-four", "twenty-five", "twenty-six",
            "twenty-seven", "twenty-eight", "twenty-nine"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int H = scanner.nextInt();
        int M = scanner.nextInt();

        System.out.println(convertTimeToWords(H, M));

        scanner.close();
    }

    private static String convertTimeToWords(int H, int M) {
        switch (M) {
            case 0:
                return NUMBERS[H] + " o’clock";
            case 15:
                return "quarter past " + NUMBERS[H];
            case 30:
                return "half past " + NUMBERS[H];
            case 45:
                return "quarter to " + NUMBERS[(H % 12) + 1];
            case 1:
                return "one minute past " + NUMBERS[H];
            default:
                if (M < 30) {
                    return NUMBERS[M] + " minutes past " + NUMBERS[H];
                } else {
                    return NUMBERS[60 - M] + " minutes to " + NUMBERS[(H % 12) + 1];
                }
        }
    }
}
