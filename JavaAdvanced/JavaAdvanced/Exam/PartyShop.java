package JavaAdvanced2021.JavaAdvanced.Exam;

import java.util.*;
import java.util.stream.Collectors;

public class PartyShop {
    static int biscuit = 25;
    static int cake = 50;
    static int pastry = 75;
    static int pie = 100;
    static int countBiscuit = 0;
    static int countCake = 0;
    static int countPastry = 0;
    static int countPie = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .forEach(queue::offer);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .forEach(stack::push);

        Map<String, Integer> mapShop = new TreeMap<>();

        while (!queue.isEmpty() && !stack.isEmpty()) {
            int sum = 0;
            int liquids = queue.peek();
            int ingredients = stack.peek();
            sum = liquids + ingredients;

            if (sum == biscuit) {
                countBiscuit++;
                queue.poll();
                stack.pop();
            }else if (sum == cake) {
                countCake++;
                queue.poll();
                stack.pop();
            }else if (sum == pastry) {
                countPastry++;
                queue.poll();
                stack.pop();
            }else if (sum == pie) {
                countPie++;
                queue.poll();
                stack.pop();
            }else {
                queue.poll();
                stack.push(stack.pop() + 3);
            }
        }
        if (countBiscuit >= 1 && countCake >= 1 && countPastry >= 1 && countPie >= 1) {
            System.out.println("Great! You succeeded in cooking all the food!");
        }else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        printLiquids(queue);
        printIngredients(stack);

        System.out.printf("Biscuit: %d%n", countBiscuit);
        System.out.printf("Cake: %d%n", countCake);
        System.out.printf("Pie: %d%n", countPie);
        System.out.printf("Pastry: %d%n", countPastry);
    }

    private static void printLiquids(ArrayDeque<Integer> queue) {
        if (queue.isEmpty()) {
            System.out.println("Liquids left: none");
        }else {
            List<Integer> liquidsLeft = new ArrayList<>();
            while (!queue.isEmpty()) {
                liquidsLeft.add(queue.poll());
            }
            String liquids = liquidsLeft.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Liquids left: " + liquids);
        }
    }

    private static void printIngredients(ArrayDeque<Integer> stack) {
        if (stack.isEmpty()) {
            System.out.println("Ingredients left: none");
        }else {
            List<Integer> ingredientsLeft = new ArrayList<>();
            while (!stack.isEmpty()) {
                ingredientsLeft.add(stack.pop());
            }
            String ingredients = ingredientsLeft.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Ingredients left: " + ingredients);
        }
    }
}
