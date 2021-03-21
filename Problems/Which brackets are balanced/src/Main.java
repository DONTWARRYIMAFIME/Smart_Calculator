import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Deque<String> stack = new ArrayDeque<>();

        boolean correct = true;

        for (int i = 0; i < input.length(); i++) {
            try {
                String symbol = String.valueOf(input.charAt(i));
                if (!isCloseBracket(symbol)) {
                    stack.offerLast(symbol);
                } else {
                    if (!Objects.equals(symbol, getParentBracket(stack.pollLast()))) {
                        correct = false;
                        break;
                    }
                }
            } catch (NullPointerException e) {
                correct = false;
                break;
            }
        }

        if (!stack.isEmpty()) correct = false;

        System.out.println(correct);

    }

    public static boolean isCloseBracket(String bracket) {
        if (bracket == null) return false;
        return bracket.matches("\\)|\\]|\\}");
    }

    public static String getParentBracket(String bracket) {
        switch (bracket) {
            case "(" :
                return ")";
            case "[" :
                return "]";
            case "{" :
                return "}";
            default:
                return "";
        }
    }
}