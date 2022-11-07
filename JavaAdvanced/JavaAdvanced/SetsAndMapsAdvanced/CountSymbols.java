package JavaAdvanced2021.JavaAdvanced.SetsAndMapsAdvancedExercises2309;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Map<Character, Integer> mapSymbol = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (!mapSymbol.containsKey(symbol)) {
                mapSymbol.put(symbol, 1);
            }else {
                mapSymbol.put(symbol, mapSymbol.get(symbol) + 1);
            }
        }
        for (var entry : mapSymbol.entrySet()) {
            System.out.printf("%c: %d time/s%n", entry.getKey(), entry.getValue());
        }
    }
}
