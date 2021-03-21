import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(Objects.equals(fillTheMap(scanner.nextLine().toLowerCase().toCharArray()),
                                          fillTheMap(scanner.nextLine().toLowerCase().toCharArray()))
                                          ? "yes" : "no");

    }

    public static Map<Character, Integer> fillTheMap(char[] line) {
        Map<Character, Integer> map = new HashMap<>();

        for (char letter : line) {
            map.merge(letter, 1, (oldVal, newVal) -> oldVal + newVal);
        }

        return map;
    }
}