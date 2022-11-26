package IteratorsAndComparators;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MainStrategy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<PersonStrategy> setName = new TreeSet<>(new ComparatorPersonName());
        Set<PersonStrategy> setAge = new TreeSet<>(new ComparatorPersonAge());

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            PersonStrategy person = new PersonStrategy(name, age);
            setName.add(person);
            setAge.add(person);
        }

        for (PersonStrategy person : setName) {
            System.out.println(person);
        }

        for (PersonStrategy person : setAge) {
            System.out.println(person);
        }
    }
}
