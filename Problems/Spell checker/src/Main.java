import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int words = scanner.nextInt();

        Set<String> dictionary = new HashSet();

        for (int i = 0; i <= words; i++) {
            dictionary.add(scanner.nextLine().toLowerCase(Locale.ROOT));
        }

        Set<String> setUnknown = new HashSet<>();

        int texts = scanner.nextInt();

        for (int i = 0; i <= texts; i++) {
            setUnknown.addAll(List.of(scanner.nextLine().toLowerCase().split("\\s+")));
        }

        setUnknown.removeAll(dictionary);
        setUnknown.forEach(System.out::println);

    }
}