package JavaAdvanced2021.JavaAdvanced.StacksAndQueuesExercises1609;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        ArrayDeque<String> stackNumber = new ArrayDeque<>();
        for (String digit : input) {
            stackNumber.push(digit);
        }

        while (!stackNumber.isEmpty()) {
            System.out.print(stackNumber.pop() + " ");
        }
    }
}
