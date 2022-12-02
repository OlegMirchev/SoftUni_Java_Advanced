package JavaAdvancedExam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FlowerWreaths {
    public static final int wreath = 15;
    public static int countWreath = 0;
    public static int leftFlower = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stackLilies = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(stackLilies::push);

        ArrayDeque<Integer> queueRoses = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(queueRoses::offer);

        while (!stackLilies.isEmpty() && !queueRoses.isEmpty()) {
            int lilie = stackLilies.peek();
            int rose = queueRoses.peek();

            int sum = lilie + rose;

            if (sum == wreath) {
                countWreath++;
                stackLilies.pop();
                queueRoses.poll();
            }else if (sum < wreath) {
                leftFlower += sum;
                stackLilies.pop();
                queueRoses.poll();
            }

            storeLater(stackLilies, queueRoses, lilie, rose, sum);
        }

        int otherWreath = leftFlower / wreath;
        countWreath += otherWreath;

        if (countWreath >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", countWreath);
        }else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - countWreath);
        }
    }

    private static void storeLater(ArrayDeque<Integer> stackLilies, ArrayDeque<Integer> queueRoses, int lilie, int rose, int sum) {

        if (sum > wreath)
        while (true) {
            lilie -= 2;
            sum = lilie + rose;
            if (sum == wreath) {
                countWreath++;
                stackLilies.pop();
                queueRoses.poll();
                break;
            }else if (sum < wreath) {
                leftFlower += sum;
                stackLilies.pop();
                queueRoses.poll();
                break;
            }
        }
    }
}
