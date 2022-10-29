package JavaAdvanced2021.JavaAdvanced.StackAndQueuesLAB1509;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numb = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stackNumber = new ArrayDeque<>();

        Collections.addAll(stackNumber, numb);

        while (stackNumber.size() > 1) {
            int first = Integer.parseInt(stackNumber.pop());
            String operator = stackNumber.pop();
            int second = Integer.parseInt(stackNumber.pop());

            switch (operator) {
                case "+":
                    stackNumber.push(String.valueOf(first + second));
                    break;
                case "-":
                    stackNumber.push(String.valueOf(first - second));
                    break;
            }
        }
        System.out.println(stackNumber.pop());
    }
}
