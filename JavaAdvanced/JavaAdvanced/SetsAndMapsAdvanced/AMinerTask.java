package JavaAdvanced2021.JavaAdvanced.SetsAndMapsAdvancedExercises2309;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        Map<String, Integer> mapResource = new LinkedHashMap<>();

        while (!command.equals("stop")) {
            String resource = command;
            int quantity = Integer.parseInt(scanner.nextLine());

            if (!mapResource.containsKey(resource)) {
                mapResource.put(resource, quantity);
            }else {
                mapResource.put(resource, mapResource.get(resource) + quantity);
            }

            command = scanner.nextLine();
        }
        for (var entry : mapResource.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
