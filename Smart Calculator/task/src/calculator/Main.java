package calculator;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Commands commands = new Commands();
        Map<String, BigInteger> map = new HashMap<>();
        
        while (!commands.isExit()) {
            String input = Logical.prepareStr(scanner.nextLine());

            if (Logical.isCommand(input)) {
                commands.executeCommand(input);
            } else if (Logical.isAssigment(input)) {
                if (!Logical.addAssigment(input, map)) {
                    System.out.println("Invalid expression");
                }
            } else if (Logical.isExpression(input)) {

                if (Logical.isCorrectBrackets(input)) {

                    String postfix = Logical.getPostfixString(Logical.convertToList(input));
                    //System.out.println(postfix);

                    if (Logical.getPostfixExpressionRang(postfix) == 1) {
                        Calculator.calculatePostfixExpression(postfix, map);
                    } else {
                        System.out.println("Invalid expression");
                    }
                } else {
                    System.out.println("Invalid expression");
                }

            } else {
                System.out.println("Invalid expression");
            }

        }
    }
}





