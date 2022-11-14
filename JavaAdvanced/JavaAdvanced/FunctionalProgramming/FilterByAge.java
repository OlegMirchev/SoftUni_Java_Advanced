package JavaAdvanced2021.JavaAdvanced.FunctionalProgrammingLAB2809;

import java.util.*;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> people = new LinkedHashMap<>();
        Map<String, Integer> mapPrintPeople = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] person = scanner.nextLine().split(", ");
            String name = person[0];
            int age = Integer.parseInt(person[1]);
            people.put(name, age);
        }
        getYoungerOrOlder(scanner, people, mapPrintPeople);
        getFormat(scanner, mapPrintPeople);
    }

    private static void getYoungerOrOlder(Scanner scanner,Map<String, Integer> people, Map<String, Integer> stringIntegerMap) {
        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        for (var entry : people.entrySet()) {
            switch (condition) {
                case "younger":
                    if (entry.getValue() <= age) {
                        stringIntegerMap.put(entry.getKey(), entry.getValue());
                    }
                    break;
                case "older":
                    if (entry.getValue() >= age) {
                        stringIntegerMap.put(entry.getKey(), entry.getValue());
                    }
                    break;
            }
        }
    }

    private static void getFormat(Scanner scanner, Map<String, Integer> people) {
        String input = scanner.nextLine();
        if (input.equals("name age")) {
            people.entrySet().forEach(r -> System.out.println(r.getKey() + " - " + r.getValue()));
        }else if (input.equals("name")) {
            people.entrySet().forEach(r -> System.out.println(r.getKey()));
        }else if (input.equals("age")) {
            people.entrySet().forEach(r -> System.out.println(r.getValue()));
        }
    }
}
