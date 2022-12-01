package JavaAdvancedExam;

import java.util.*;
import java.util.stream.Collectors;

public class Bombs {
    public static final int DATURA_BOMBS = 40;
    public static final int CHERRY_BOMBS = 60;
    public static final int SMOKE_DECOY_BOMBS = 120;
    public static int daturaBombs = 0;
    public static int cherryBombs = 0;
    public static int smokeBombs = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> queueEffect = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(queueEffect::offer);

        ArrayDeque<Integer> stackCasing = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(stackCasing::push);

        List<Integer> queueList = new ArrayList<>();
        List<Integer> stackList = new ArrayList<>();

        boolean isFillPouch = false;

        while (!queueEffect.isEmpty() && !stackCasing.isEmpty()) {
            int queue = queueEffect.poll();
            int stack = stackCasing.pop();

            int sumBomb = queue + stack;

            if (sumBomb == DATURA_BOMBS) {
                daturaBombs++;
            }else if (sumBomb == CHERRY_BOMBS) {
                cherryBombs++;
            }else if (sumBomb == SMOKE_DECOY_BOMBS) {
                smokeBombs++;
            }else {
                decreaseValueCasing(queue, stack);
            }

            if (daturaBombs >= 3 && cherryBombs >= 3 && smokeBombs >= 3) {
                isFillPouch = true;
                break;
            }
        }
        while (!queueEffect.isEmpty()) {
            queueList.add(queueEffect.poll());
        }
        while (!stackCasing.isEmpty()) {
            stackList.add(stackCasing.pop());
        }

        if (isFillPouch) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (queueList.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        }else {
            System.out.println("Bomb Effects: " + queueList.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        if (stackList.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        }else {
            System.out.println("Bomb Casings: " + stackList.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        System.out.println("Cherry Bombs: " + cherryBombs);
        System.out.println("Datura Bombs: " + daturaBombs);
        System.out.println("Smoke Decoy Bombs: " + smokeBombs);
    }

    private static void decreaseValueCasing(int queue, int stack) {
        int sumBomb;
        while (true) {
           stack -= 5;
           sumBomb = queue + stack;
           if (sumBomb == DATURA_BOMBS) {
               daturaBombs++;
               break;
           }else if (sumBomb == CHERRY_BOMBS) {
               cherryBombs++;
               break;
           }else if (sumBomb == SMOKE_DECOY_BOMBS) {
               smokeBombs++;
               break;
           }
        }
    }
}
