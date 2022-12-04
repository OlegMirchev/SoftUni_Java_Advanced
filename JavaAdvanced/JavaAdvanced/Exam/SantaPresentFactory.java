package JavaAdvancedExam;

import java.util.*;
import java.util.stream.Collectors;

public class SantaPresentFactory {
    public static final int DOLL = 150;
    public static final int WOODEN_TRAIN = 250;
    public static final int TEDDY_BEAR = 300;
    public static final int BICYCLE = 400;
    public static int dollCount = 0;
    public static int trainCount = 0;
    public static int bearCount = 0;
    public static int bicycleCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stackMaterial = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(stackMaterial::push);

        ArrayDeque<Integer> queueMagic = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(queueMagic::offer);

        stackMaterial.removeIf(n -> n == 0);
        queueMagic.removeIf(n -> n == 0);

        List<Integer> listMaterials = new ArrayList<>();
        List<Integer> listMagic = new ArrayList<>();


        while (!stackMaterial.isEmpty() && !queueMagic.isEmpty()) {
            int materials = stackMaterial.poll();
            int magic = queueMagic.pop();

            int toy = materials * magic;

            if (toy == DOLL) {
                dollCount++;
            }else if (toy == WOODEN_TRAIN) {
                trainCount++;
            }else if (toy == TEDDY_BEAR) {
                bearCount++;
            }else if (toy == BICYCLE) {
                bicycleCount++;
            }else if (toy < 0) {
                int sumNegativeNumber = Math.abs(materials + magic);
                if (sumNegativeNumber == 0) {
                    continue;
                }
                stackMaterial.push(sumNegativeNumber);
            }else {
                stackMaterial.push(materials + 15);
            }
        }

        while (!stackMaterial.isEmpty()) {
            listMaterials.add(stackMaterial.pop());
        }

        while (!queueMagic.isEmpty()) {
            listMagic.add(queueMagic.poll());
        }

        if ((bicycleCount > 0 && bearCount > 0) || (dollCount > 0 && trainCount > 0)) {
            System.out.println("The presents are crafted! Merry Christmas!");
        }else {
            System.out.println("No presents this Christmas!");
        }

        if (!listMaterials.isEmpty()) {
            System.out.println("Materials left: " + listMaterials.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (!listMagic.isEmpty()) {
            System.out.println("Magic left: " + listMagic.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (bicycleCount > 0) {
            System.out.println("Bicycle: " + bicycleCount);
        }
        if (dollCount > 0) {
            System.out.println("Doll: " + dollCount);
        }
        if (bearCount > 0) {
            System.out.println("Teddy bear: " + bearCount);
        }
        if (trainCount > 0) {
            System.out.println("Wooden train: " + trainCount);
        }
    }
}
