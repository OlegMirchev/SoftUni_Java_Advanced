package JavaAdvanced2021.JavaAdvanced.SetsAndMapsAdvancedLAB2109;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputNumber = scanner.nextLine().split("\\s+");

        Map<String, Integer> mapRealNumb = new LinkedHashMap<>();

        for (int i = 0; i < inputNumber.length; i++) {
            if (!mapRealNumb.containsKey(String.valueOf(inputNumber[i]))) {
                mapRealNumb.put(String.valueOf(inputNumber[i]), 1);
            }else {
                mapRealNumb.put(inputNumber[i], mapRealNumb.get(inputNumber[i]) + 1);
            }
        }
        for (var entry : mapRealNumb.entrySet()) {
            System.out.printf("%.1f -> %d%n", Double.parseDouble(entry.getKey()), entry.getValue());
        }
    }
}
