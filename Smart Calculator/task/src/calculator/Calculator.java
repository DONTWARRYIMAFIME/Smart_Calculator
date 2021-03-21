package calculator;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class Calculator {

    public static void calculatePostfixExpression(String str, Map<String, BigInteger> map) {
        Deque<BigInteger> stack = new ArrayDeque<>();
        boolean error = false;

        String[] symbols = str.split("\\s");

        for (String symbol : symbols) {

            if (Logical.isOperand(symbol)) {
                if (Logical.isNumber(symbol)) {
                    try {
                        stack.offerLast(new BigInteger(symbol));
                    } catch (NumberFormatException e) {
                        error = true;
                        break;
                    }
                } else if (Logical.isVariable(symbol)) {
                    try {
                        stack.offerLast(map.get(symbol));
                    } catch (NullPointerException e) {
                        error = true;
                        System.out.println("Unknown variable");
                        break;
                    }
                } else {
                    error = true;
                    break;
                }
            } else {

                BigInteger firstOperator;
                BigInteger secondOperator;

                try {
                    firstOperator = stack.pollLast();
                    secondOperator = stack.pollLast();
                } catch (NullPointerException e) {
                    error = true;
                    break;
                }

                BigInteger result = BigInteger.ZERO;

                switch (symbol) {
                    case "+":
                        result = addNumbers(secondOperator, firstOperator);
                        break;
                    case "-":
                        result = subtractNumbers(secondOperator, firstOperator);
                        break;
                    case "*":
                        result = multiplyNumbers(secondOperator, firstOperator);
                        break;
                    case "/":
                        result = divideNumbers(secondOperator, firstOperator);
                        break;
                    case "^":
                        result = elevateNumber(secondOperator, Integer.parseInt(firstOperator.toString()));
                        break;
                    default:
                        error = true;
                        //System.out.format("Couldn't identify operator %s in position %d", arr[i], i);
                        break;
                }

                stack.offerLast(result);

            }
        }

        System.out.println(error ? "Invalid expression" : stack.pollLast());
    }

    public static BigInteger addNumbers(BigInteger a, BigInteger b) {
        return a.add(b);
    }

    public static BigInteger subtractNumbers(BigInteger a, BigInteger b) {
        return a.subtract(b);
    }

    public static BigInteger divideNumbers(BigInteger a, BigInteger b) {
        return a.divide(b);
    }

    public static BigInteger multiplyNumbers(BigInteger a, BigInteger b) {
        return a.multiply(b);
    }

    public static BigInteger elevateNumber(BigInteger a, int power) {
        BigInteger result = a;

        for (int i = 0; i < power - 1; i++) {
            result = result.multiply(a);
        }

        return result;
    }

}