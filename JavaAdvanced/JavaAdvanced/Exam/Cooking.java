package JavaAdvancedExam;

import java.util.*;

public class Cooking {
    public static final int bread = 25;
    public static final int cake = 50;
    public static final int pastry = 75;
    public static final int fruitPie = 100;
    public static int breadCount = 0;
    public static int cakeCount = 0;
    public static int pastryCount = 0;
    public static int fruitPieCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> queueLiquids = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(queueLiquids::offer);

        ArrayDeque<Integer> stackIngredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(stackIngredients::push);

        List<String> liquids = new ArrayList<>();
        List<String> ingredients = new ArrayList<>();

        while (!queueLiquids.isEmpty() && !stackIngredients.isEmpty()) {
            int liquid = queueLiquids.poll();
            int ingredient = stackIngredients.pop();

            int sum = liquid + ingredient;

            if (sum == bread) {
                breadCount++;
            }else if (sum == cake) {
                cakeCount++;
            }else if (sum == pastry) {
                pastryCount++;
            }else if (sum == fruitPie) {
                fruitPieCount++;
            }else {
                stackIngredients.push(ingredient + 3);
            }
        }
        while (!queueLiquids.isEmpty()) {
            liquids.add(String.valueOf(queueLiquids.poll()));
        }
        while (!stackIngredients.isEmpty()) {
            ingredients.add(String.valueOf(stackIngredients.pop()));
        }

        if (breadCount >= 1 && cakeCount >= 1 && pastryCount >= 1 && fruitPieCount >= 1) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        leftItems(liquids, ingredients);

        System.out.println("Bread: " + breadCount);
        System.out.println("Cake: " + cakeCount);
        System.out.println("Fruit Pie: " + fruitPieCount);
        System.out.println("Pastry: " + pastryCount);
    }

    private static void leftItems(List<String> liquids, List<String> ingredients) {
        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        }else {
            System.out.print("Liquids left: " + String.join(", ", liquids));
            System.out.println();
        }

        if (ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        }else {
            System.out.print("Ingredients left: " + String.join(", ", ingredients));
            System.out.println();
        }
    }
}
