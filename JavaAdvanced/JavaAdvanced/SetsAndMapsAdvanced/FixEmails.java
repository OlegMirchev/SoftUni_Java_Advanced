package JavaAdvanced2021.JavaAdvanced.SetsAndMapsAdvancedExercises2309;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        Map<String, String> mapEmails = new LinkedHashMap<>();

        while (!command.equals("stop")) {
            String name = command;
            String email = scanner.nextLine();

            if (!(email.endsWith("com") || email.endsWith("us") || email.endsWith("uk"))) {
                mapEmails.put(name, email);
            }
            command = scanner.nextLine();
        }
        for (var entry : mapEmails.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
