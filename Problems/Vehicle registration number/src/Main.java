import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regNum = scanner.nextLine(); // a valid or invalid registration number

        String Latin = "[ABEKMHOPCTYX]";
        String regExp = Latin + "\\d{3}" + Latin + "{2}";

        System.out.println(regNum.matches(regExp));

    }
}