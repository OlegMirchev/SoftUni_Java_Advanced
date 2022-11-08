package JavaAdvanced2021.JavaAdvanced.SetsAndMapsAdvancedExercises2309;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, String> mapPhoneBook = new LinkedHashMap<>();

        while (!input.equals("search")) {
            String[] phoneBook = input.split("-");
            String name = phoneBook[0];
            String phoneNumber = phoneBook[1];

            mapPhoneBook.put(name, phoneNumber);

            input = scanner.nextLine();
        }
        String command = scanner.nextLine();

        while (!command.equals("stop")) {
            if (mapPhoneBook.containsKey(command)) {
                System.out.printf("%s -> %s%n", command, mapPhoneBook.get(command));
            }else {
                System.out.printf("Contact %s does not exist.%n", command);
            }
            command = scanner.nextLine();
        }
    }
}
