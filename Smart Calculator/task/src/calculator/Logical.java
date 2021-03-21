package calculator;

import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Logical {

    static String prepareStr(String str) {
        String result = str.trim().replaceAll("\\s+","");

        result = result.replaceAll("(-{2})+", "+");
        result = result.replaceAll("(\\+-|-\\+)","-");
        result = result.replaceAll("\\++", "+");

        return result;
    }

    static boolean isCorrectBrackets(String str) {
        Deque<String> stack = new ArrayDeque<>();
        boolean correct = true;

        for (int i = 0; i < str.length(); i++) {

            String symbol = String.valueOf(str.charAt(i));
            if ("(".equals(symbol)) {
                stack.offerLast(symbol);
            } else if (")".equals(symbol)) {
                if (stack.isEmpty()) {
                    correct = false;
                    break;
                }

                stack.pollLast();
            }
        }

        if (!stack.isEmpty()) {
            correct = false;
        }

        return correct;
    }

    static List<String> convertToList(String str) {
        List<String> list = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\d+|[A-Za-z]+|[+\\-*/^()]");
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            list.add(matcher.group());
        }

        return list;
    }

    static boolean isCommand(String str) {
        return str.length() == 0 || str.matches("/[a-z]+");
    }

    static boolean isAssigment(String str) {
        return str.matches("[A-Za-z]+=((-?\\d+)|[A-Za-z]+)");
    }

    static boolean isExpression(String str) {
        return  str.matches("(\\s|\\()*([A-Za-z]+|\\d+)\\s*(([+\\-*/^]*)(\\s|\\()*\\s*([A-Za-z]+|\\d+)(\\s|\\))*\\s*)*");
    }
    
    static boolean isOperand(String str) {
        return str.matches("[-+]?\\w+");
    }

    static boolean isNumber(String str) {
        return str.matches("-?\\d+");
    }

    static boolean isVariable(String str) {
        return str.matches("[A-Za-z]+");
    }

    static boolean addAssigment(String str, Map<String, BigInteger> map) {

        String[] symbols = str.split("\\s*=\\s*");

        try {
            map.merge(symbols[0], new BigInteger(symbols[1]), (oldVal, newVal) -> newVal);
        } catch (NumberFormatException e) {

            try {
                map.merge(symbols[0], map.get(symbols[1]), (oldVal, newVal) -> newVal);
            } catch (NullPointerException e1) {
                return false;
            }
        }
        return true;
    }

    static String getPostfixString(List<String> symbols) {
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder postfix = new StringBuilder();

        for (String symbol : symbols) {

            if (isOperand(symbol)) {
                postfix.append(symbol).append(" ");
            } else if (")".equals(symbol)) {
                while (!stack.isEmpty()) {
                    if ("(".equals(stack.peekLast())) {
                        stack.pollLast();
                        break;
                    }
                    postfix.append(stack.pollLast()).append(" ");
                }
            } else {
                if (!"(".equals(symbol) ) {


                    while (!stack.isEmpty()
                            && !"(".equals(stack.peekLast())
                            && getPriority(stack.peekLast()) >= getPriority(symbol)) {

                        postfix.append(stack.pollLast()).append(" ");

                    }

                }
                stack.offerLast(symbol);

            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pollLast()).append(" ");
        }

        return postfix.toString();
    }

    static int getPriority(String symbol) {

        switch (symbol) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
            default:
                System.out.format("Unhandled symbol %s\n", symbol);
                return 0;

        }
    }

    static int getSymbolRang(String symbol) {
        if (isNumber(symbol) || isVariable(symbol)) {
            return 1;
        } else {
            return -1;
        }
    }
    
    static int getPostfixExpressionRang(String str) {
        String[] symbols = str.split("\\s");
        
        int rang = 0;
        
        for (String symbol : symbols) {
            rang += getSymbolRang(symbol);
        }
        
        return rang;
    }
    
}
