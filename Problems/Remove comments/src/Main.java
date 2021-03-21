import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String codeWithComments = scanner.nextLine();

        codeWithComments = codeWithComments.replaceAll("/\\*.*?\\*/", "");
        codeWithComments = codeWithComments.replaceAll("//.*", "");

        System.out.println(codeWithComments);
    }
}