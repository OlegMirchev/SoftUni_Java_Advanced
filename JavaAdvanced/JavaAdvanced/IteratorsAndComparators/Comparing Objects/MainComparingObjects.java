package IteratorsAndComparators;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainComparingObjects {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<PersonComparingObjects> listPerson = new ArrayList<>();

        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String town = tokens[2];

            PersonComparingObjects person = new PersonComparingObjects(name, age, town);
            listPerson.add(person);

            input = scanner.nextLine();
        }
        int index = Integer.parseInt(scanner.nextLine());
        PersonComparingObjects comparePerson = listPerson.get(index - 1);
        listPerson.remove(index - 1);
        int samePerson = 0;
        int differentPerson = 0;

        for (PersonComparingObjects person : listPerson) {
            if (person.compareTo(comparePerson) == 0) {
                samePerson++;
            }else {
                differentPerson++;
            }
        }
        if (samePerson == 0) {
            System.out.println("No matches");
        }else {
            System.out.printf("%d %d %d%n", ++samePerson, differentPerson, listPerson.size() + 1);
        }
    }
}
