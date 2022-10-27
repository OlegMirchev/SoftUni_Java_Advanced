package JavaAdvanced2021.JavaAdvanced.StackAndQueuesLAB1509;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayDeque<Integer> stackSubstring = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (symbol == '(') {
                stackSubstring.push(i);
            }else if (symbol == ')') {
                int startIndex = stackSubstring.pop();
                System.out.println(input.substring(startIndex, i + 1));
            }
        }
    }
}
