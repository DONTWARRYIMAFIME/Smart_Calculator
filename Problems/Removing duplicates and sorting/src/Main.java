import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        Set<String> set = new TreeSet();

        for (int i = 0; i <= len; i++) {
            set.add(scanner.nextLine());
        }

        set.forEach(elem -> System.out.println(elem));

    }
}