package JavaAdvanced2021.JavaAdvanced.StacksAndQueuesExercises1609;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean isValid = false;

        ArrayDeque<Character> stackParentheses = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (symbol == '{' || symbol == '[' || symbol == '(') {
                stackParentheses.push(symbol);
            } else if (symbol == '}' || symbol == ']' || symbol == ')') {
                if (stackParentheses.isEmpty()) {
                    isValid = false;
                    break;
                }
                char openParentheses = stackParentheses.pop();
                if ((openParentheses == '(' && symbol == ')') || (openParentheses == '[' && symbol == ']')
                        || (openParentheses == '{' && symbol == '}')) {
                    isValid = true;
                }else {
                    isValid = false;
                    break;
                }
            }
        }
        if (isValid) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
