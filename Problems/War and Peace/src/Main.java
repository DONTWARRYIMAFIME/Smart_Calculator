import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();

        String[] arr = scanner.nextLine().toLowerCase().split("\\s+");

        for (String word : arr) {
            map.merge(word, 1, (oldVal, newVal) -> oldVal + newVal);
        }

        map.forEach((key, value) -> System.out.format("%s %d\n", key, value));
    }
}