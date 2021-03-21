import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger[] bigs = new BigInteger[4];

        for (int i = 0; i < bigs.length; i++) {
            bigs[i] = new BigInteger(scanner.next());
        }

        BigInteger result = calculate(bigs[0], bigs[1], bigs[2], bigs[3]);
        System.out.println(result);
    }

    public static BigInteger calculate (BigInteger a, BigInteger b, BigInteger c, BigInteger d) {
        return a.negate().multiply(b).add(c).subtract(d);
    }
}