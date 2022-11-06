package JavaAdvanced2021.JavaAdvanced.SetsAndMapsAdvancedLAB2109;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<String>>> mapDate = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String cities = input[2];

            mapDate.putIfAbsent(continent, new LinkedHashMap<>());
            mapDate.get(continent).putIfAbsent(country, new ArrayList<>());
            mapDate.get(continent).get(country).add(cities);

        }
        mapDate.forEach((key, value) -> {
            System.out.println(key + ":");
            value.forEach((countryKey, cityValue) -> {
                System.out.println("  " + countryKey + " -> " + String.join(", ", cityValue));

            });
        });
    }
}

