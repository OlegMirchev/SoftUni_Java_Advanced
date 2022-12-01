package JavaAdvancedExam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bouquets {
    public static final int bouquets = 15;
    public static int totalBouquets = 5;
    public static int createBouquets = 0;
    public static int sumFlower = 0;
    public static int leftFlower = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stackTulips = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(stackTulips::push);

        ArrayDeque<Integer> queueDaffodils = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(queueDaffodils::offer);


        while (!queueDaffodils.isEmpty() && !stackTulips.isEmpty()) {
            int tulip = stackTulips.peek();
            int daffodil = queueDaffodils.peek();

            sumFlower = daffodil + tulip;

            if (sumFlower == bouquets) {
                createBouquets++;
                queueDaffodils.poll();
                stackTulips.pop();
            }else if (sumFlower < bouquets) {
                leftFlower += sumFlower;
                queueDaffodils.poll();
                stackTulips.pop();
            }

            extracted(stackTulips, queueDaffodils, tulip, daffodil);
        }

        if (leftFlower >= bouquets) {
            while (leftFlower >= bouquets) {
                leftFlower -= bouquets;
                createBouquets++;
            }
        }

        if (createBouquets >= totalBouquets) {
            System.out.printf("You made it! You go to the competition with %d bouquets!%n", createBouquets);
        }else {
            System.out.printf("You failed... You need more %d bouquets.", totalBouquets - createBouquets);
        }
    }

    private static void extracted(ArrayDeque<Integer> stackTulips, ArrayDeque<Integer> queueDaffodils, int tulip, int daffodil) {

        if (sumFlower > bouquets) {
            while (true) {
               tulip -= 2;
               sumFlower = daffodil + tulip;
               if (sumFlower == bouquets) {
                   createBouquets++;
                   queueDaffodils.poll();
                   stackTulips.pop();
                   break;
               }else if (sumFlower < bouquets) {
                   leftFlower += sumFlower;
                   queueDaffodils.poll();
                   stackTulips.pop();
                   break;
               }
           }
        }
    }
}
