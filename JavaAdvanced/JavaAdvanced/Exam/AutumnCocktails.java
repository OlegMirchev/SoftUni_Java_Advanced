package JavaAdvancedExam;

import java.util.*;

public class AutumnCocktails {
    public static final int pearSour = 150;
    public static final int theHarvest = 250;
    public static final int appleHinny = 300;
    public static final int highFashion = 400;
    public static int pearSourCount = 0;
    public static int theHarvestCount = 0;
    public static int appleHinnyCount = 0;
    public static int highFashionCount = 0;
    public static int ingredientsLeft = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> queueIngredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(queueIngredients::offer);

        ArrayDeque<Integer> stackFreshness = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(stackFreshness::push);

        Map<String, Integer> mapCocktails = new TreeMap<>();

        while (!queueIngredients.isEmpty() && !stackFreshness.isEmpty()) {
            int queuePeek = queueIngredients.poll();
            if (queuePeek == 0) {
                continue;
            }
            int stackPeek = stackFreshness.pop();

            int mixCocktail = queuePeek * stackPeek;


            if (mixCocktail == pearSour) {
                pearSourCount++;
                mapCocktails.put("Pear Sour", pearSourCount);
            } else if (mixCocktail == theHarvest) {
                theHarvestCount++;
                mapCocktails.put("The Harvest", theHarvestCount);
            }else if (mixCocktail == appleHinny) {
                appleHinnyCount++;
                mapCocktails.put("Apple Hinny", appleHinnyCount);
            }else if (mixCocktail == highFashion) {
                highFashionCount++;
                mapCocktails.put("High Fashion", highFashionCount);
            } else {
                queueIngredients.offer(queuePeek + 5);
            }
        }

        while (!queueIngredients.isEmpty()) {
            ingredientsLeft += queueIngredients.poll();
        }

        if (mapCocktails.size() == 4) {
            System.out.println("It's party time! The cocktails are ready!");
        }else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (ingredientsLeft > 0) {
            System.out.printf("Ingredients left: %d%n", ingredientsLeft);
        }

        for (var entry : mapCocktails.entrySet()) {
            System.out.printf(" # %s --> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
