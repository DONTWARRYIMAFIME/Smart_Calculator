import java.math.BigInteger;

class DoubleFactorial {
    public static BigInteger calcDoubleFactorial(int n) {

        BigInteger result = BigInteger.ONE;
        for (int i = n; i > 0; i -= 2) {
            result = result.multiply(new BigInteger(Integer.toString(i)));
        }

        return result;
    }

}