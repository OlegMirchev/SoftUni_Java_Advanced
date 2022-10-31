package JavaAdvanced2021.JavaAdvanced.StacksAndQueuesExercises1609;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();

        ArrayDeque<Integer> stackNumber = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            stackNumber.push(scanner.nextInt());
        }
        for (int j = 1; j <= s; j++) {
            stackNumber.pop();
        }
        if (stackNumber.contains(x)) {
            System.out.println("true");
        } else {
            if (!stackNumber.isEmpty()) {
                System.out.println(getMin(stackNumber));
            }else {
                System.out.println(0);
            }
        }
    }

    private static int getMin(ArrayDeque<Integer> stackNumber) {
        int min = Integer.MAX_VALUE;
        while (!stackNumber.isEmpty()) {
            int currentNumb = stackNumber.pop();

            if (currentNumb < min) {
                min = currentNumb;
            }
        }
        return min;
    }
}

