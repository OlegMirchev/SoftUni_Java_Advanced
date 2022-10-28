package JavaAdvanced2021.JavaAdvanced.StackAndQueuesLAB1509;

import java.util.*;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] name = scanner.nextLine().split("\\s+");
        int numb = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queueName = new ArrayDeque<>();
        Collections.addAll(queueName, name);
        int cycle = 1;

        while (queueName.size() > 1) {
            for (int i = 1; i < numb; i++) {
                queueName.offer(queueName.poll());
            }
           if (isPrime(cycle)) {
                System.out.println("Prime " + queueName.peek());
            } else{
                System.out.println("Removed " + queueName.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + queueName.poll());
    }

    private static boolean isPrime(int cycle) {
        boolean isValid = true;
        if (cycle == 0 || cycle == 1) {
            isValid = false;
        }else {
            for (int i = 2; i <= Math.sqrt(cycle); i++) {
                if (cycle % i == 0) {
                    isValid = false;
                }
                
            }
        }
        return isValid;
    }
}
