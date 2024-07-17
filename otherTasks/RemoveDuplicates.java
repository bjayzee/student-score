import java.util.*;

public class RemoveDuplicates {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<int[]> array = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] numbers = scanner.nextLine().replaceAll("[{}]", "").split(",\\s*");
            int[] row = Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
            array.add(row);
        }

        array.forEach(RemoveDuplicates::removeDuplicates);
        printArray(array);
    }

    private static void removeDuplicates(int[] row) {
        boolean[] seen = new boolean[500001];

        Arrays.stream(row).forEach(num -> {
            if (num > 0 && seen[num]) {
                row[Arrays.asList(row).indexOf(num)] = 0;
            } else if (num > 0) {
                seen[num] = true;
            }
        });
    }

    private static void printArray(List<int[]> array) {
        array.forEach(row -> {
            System.out.print("{");
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i]);
                if (i < row.length - 1) System.out.print(", ");
            }
            System.out.println("}");
        });
    }
}
