package JavaAdvanced2021.JavaAdvanced.StackAndQueuesLAB1509;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] name = scanner.nextLine().split("\\s+");
        int numb = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queueName = new ArrayDeque<>();
        Collections.addAll(queueName, name);

        while (queueName.size() > 1) {
            for (int i = 1; i < numb; i++) {
                queueName.offer(queueName.poll());
            }
            System.out.println("Removed " + queueName.poll());
        }
        System.out.println("Last is " + queueName.poll());
    }
}
