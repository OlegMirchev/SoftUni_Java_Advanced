package JavaAdvanced2021.JavaOPP.InterfacesAndAbstractionExercises0811.BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Citizen> listCitizens = new ArrayList<>();
        List<Pet> listPets = new ArrayList<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Citizen":
                  listCitizens.add(new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]));
                    break;
                case "Robot":
                    new Robot(tokens[1], tokens[2]);
                    break;
                case "Pet":
                   listPets.add(new Pet(tokens[1], tokens[2]));
                    break;
            }
            input = scanner.nextLine();
        }
        String year = scanner.nextLine();

        boolean isValid = false;

        for (Citizen citizen : listCitizens) {
            if (citizen.getBirthDate().endsWith(year)) {
                System.out.println(citizen.getBirthDate());
                isValid = true;
            }
        }

        for (Pet pet : listPets) {
            if (pet.getBirthDate().endsWith(year)) {
                System.out.println(pet.getBirthDate());
                isValid = true;
            }
        }
        if (!isValid) {
            System.out.println("<no output>");
        }
    }
}
