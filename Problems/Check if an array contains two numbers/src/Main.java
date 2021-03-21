import java.util.Arrays;
import java.util.Scanner;

class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }

        int first = scanner.nextInt();
        int second = scanner.nextInt();

        boolean result = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == first) {
                if (i == 0) {
                    if (arr[i + 1] == second) {
                        result = true;
                        break;
                    }
                } else if (i == arr.length - 1) {
                    if (arr[i - 1] == second) {
                        result = true;
                        break;
                    }
                } else {
                    if (arr[i + 1] == second || arr[i - 1] == second) {
                        result = true;
                        break;
                    }
                }
            }
        }

        System.out.println(result);

    }

}