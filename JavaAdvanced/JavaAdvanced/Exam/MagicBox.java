package JavaAdvancedExam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MagicBox {
    public static int sumClaimedItems = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> queueFirstBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(queueFirstBox::offer);

        ArrayDeque<Integer> stackSecondBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(stackSecondBox::push);

        while (!queueFirstBox.isEmpty() && !stackSecondBox.isEmpty()) {
            int queue = queueFirstBox.peek();
            int stack = stackSecondBox.pop();

            int sum = queue + stack;

            if (sum % 2 == 0) {
                sumClaimedItems += sum;
                queueFirstBox.poll();
            }else {
                queueFirstBox.offer(stack);
            }
        }

        if (queueFirstBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        }else {
            System.out.println("Second magic box is empty.");
        }

        if (sumClaimedItems >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d", sumClaimedItems);
        }else {
            System.out.printf("Poor prey... Value: %d", sumClaimedItems);
        }
    }
}
