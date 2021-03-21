import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        char[] chars = str.toCharArray();
        if (str.length() % 2 == 0) {


            for (int i = 0; i < chars.length; i++) {
                if ((i != str.length() / 2) && (i != str.length() / 2 - 1)) {
                    System.out.print(chars[i]);
                }
            }
        } else {
            for (int i = 0; i < chars.length; i++) {
                if (i != str.length() / 2) {
                    System.out.print(chars[i]);
                }
            }
        }

    }
}