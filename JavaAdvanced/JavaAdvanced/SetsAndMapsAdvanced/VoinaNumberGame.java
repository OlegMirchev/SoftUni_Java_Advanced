package JavaAdvanced2021.JavaAdvanced.SetsAndMapsAdvancedLAB2109;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayer = readSet(scanner);
        Set<Integer> secondPlayer = readSet(scanner);
        int count = 50;

        while (count-- > 0) {
            int firstCard = getDeck(firstPlayer);
            int secondCard = getDeck(secondPlayer);

            firstPlayer.remove(firstCard);
            secondPlayer.remove(secondCard);

            if (firstCard > secondCard) {
                firstPlayer.add(firstCard);
                firstPlayer.add(secondCard);
            }else if (secondCard > firstCard){
                secondPlayer.add(firstCard);
                secondPlayer.add(secondCard);
            }
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) {
                break;
            }
        }
        if (secondPlayer.size() > firstPlayer.size()) {
            System.out.println("Second player win!");
        }else if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        }else {
            System.out.println("Draw!");
        }
    }

    private static Set<Integer> readSet(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private static int getDeck(Set<Integer> firstPlayer) {
        for (Integer card : firstPlayer) {
            return card;
        }
        return 0;
    }
}
