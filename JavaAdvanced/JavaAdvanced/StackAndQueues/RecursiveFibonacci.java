package JavaAdvanced2021.JavaAdvanced.StacksAndQueuesExercises1609;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        long sumFibonacchi = 0;
        ArrayDeque<Long> queue = new ArrayDeque<>();

        if (n >= 2) {
            queue.offer(0L);
            queue.offer(1L);
            for (int i = 1; i <= n; i++) {
                sumFibonacchi = queue.poll() + queue.peek();
                queue.offer(sumFibonacchi);
            }
        }else {
            System.out.println(1);
            return;
        }
        System.out.println(queue.pollLast());
    }
}
