import java.util.*;
import java.util.stream.Collectors;

public class Blacksmith {
    public static int gladius = 70;
    public static int shamshir = 80;
    public static int katana = 90;
    public static int sabre = 110;
    public static int countGladius = 0;
    public static int countShamshir = 0;
    public static int countKatana = 0;
    public static int countSabre = 0;
    public static int totalNumberOfSwords = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(queue::offer);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(stack::push);

        List<Integer> listSteels = new ArrayList<>();
        List<Integer> listCarbons = new ArrayList<>();

        while (!queue.isEmpty() && !stack.isEmpty()) {
            int steel = queue.poll();
            int carbon = stack.pop();

            int sum = steel + carbon;

            if (sum == gladius) {
                countGladius++;
                totalNumberOfSwords++;
            } else if (sum == shamshir) {
                countShamshir++;
                totalNumberOfSwords++;
            } else if (sum == katana) {
                countKatana++;
                totalNumberOfSwords++;
            } else if (sum == sabre) {
                countSabre++;
                totalNumberOfSwords++;
            } else {
                stack.push(carbon + 5);
            }
        }

        while (!queue.isEmpty()) {
            listSteels.add(queue.poll());
        }

        while (!stack.isEmpty()) {
            listCarbons.add(stack.pop());
        }

        if (totalNumberOfSwords > 0) {
            System.out.printf("You have forged %d swords.%n", totalNumberOfSwords);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if (listSteels.isEmpty()) {
            System.out.println("Steel left: none");
        }else {
            System.out.println("Steel left: " + listSteels.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (listCarbons.isEmpty()) {
            System.out.println("Carbon left: none");
        }else {
            System.out.println("Carbon left: " + listCarbons.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (countGladius > 0) {
            System.out.println("Gladius: " + countGladius);
        }

        if (countKatana > 0) {
            System.out.println("Katana: " + countKatana);
        }

        if (countSabre > 0) {
            System.out.println("Sabre: " + countSabre);
        }

        if (countShamshir > 0) {
            System.out.println("Shamshir: " + countShamshir);
        }
    }
}
