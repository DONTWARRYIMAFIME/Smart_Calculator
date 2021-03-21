import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queue<String> q1 = new ArrayDeque<>();
        Queue<String> q2 = new ArrayDeque<>();

        int q1Load = 0;
        int q2Load = 0;

        int len = scanner.nextInt();

        for (int i = 0; i < len; i++) {

            String description = scanner.next();
            int load = scanner.nextInt();

            if (q1Load <= q2Load) {
                q1.add(description);
                q1Load += load;
            } else {
                q2.add(description);
                q2Load += load;
            }
        }

        q1.forEach(elem -> System.out.print(elem + " "));
        System.out.println();
        q2.forEach(elem -> System.out.print(elem + " "));

    }
}