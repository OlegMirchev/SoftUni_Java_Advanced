package JavaAdvanced2021.JavaAdvanced.SetsAndMapsAdvancedExercises2309;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        Map<String, Set<String>> mapPlayers = new LinkedHashMap<>();

        while (!command.equals("JOKER")) {
            String name = command.split(": ")[0];
            String[] card = command.split(": ")[1].split(", ");
            Set<String> setCards = new LinkedHashSet<>();
            Collections.addAll(setCards, card);

            if (!mapPlayers.containsKey(name)) {
                mapPlayers.put(name, setCards);
            }else {
                Set<String> setNewCurrentCards = mapPlayers.get(name);
                setNewCurrentCards.addAll(setCards);
                mapPlayers.put(name, setNewCurrentCards);
            }

            command = scanner.nextLine();
        }
        for (var playerEntry : mapPlayers.entrySet()) {
            int pointsCard = getCardsPointCollect(playerEntry.getValue());
            System.out.println(playerEntry.getKey() + ": " + pointsCard);
        }
    }

    private static int getCardsPointCollect(Set<String> cards) {
        int sumCards = 0;
        Map<Character, Integer> points = getPointValue();
        for (String card : cards) {
            int cardPoints = 0;
            if (card.contains("10")) {
                char symbol = card.charAt(2);
                cardPoints = 10 * points.get(symbol);
            } else {
                char numberCard = card.charAt(0);
                char powerCard = card.charAt(1);
                cardPoints = points.get(numberCard) * points.get(powerCard);

            }
            sumCards += cardPoints;
        }
        return sumCards;
    }

    private static Map<Character, Integer> getPointValue() {
        Map<Character, Integer> points = new LinkedHashMap<>();
        points.put('1', 1);
        points.put('2', 2);
        points.put('3', 3);
        points.put('4', 4);
        points.put('5', 5);
        points.put('6', 6);
        points.put('7', 7);
        points.put('8', 8);
        points.put('9', 9);
        points.put('J', 11);
        points.put('Q', 12);
        points.put('K', 13);
        points.put('A', 14);
        points.put('S', 4);
        points.put('H', 3);
        points.put('D', 2);
        points.put('C', 1);

        return points;
    }
}
