import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        boolean strong = true;

        String[] expressions = new String[4];
        expressions[0] = "\\w{12,}";
        expressions[1] = ".*\\d+.*";
        expressions[2] = ".*[A-Z]+.*";
        expressions[3] = ".*[a-z]+.*";

        for (String regExp : expressions) {
            if (!input.matches(regExp)) {
                strong = false;
                break;
            }
        }

        System.out.println(strong ? "YES" : "NO");

    }
}