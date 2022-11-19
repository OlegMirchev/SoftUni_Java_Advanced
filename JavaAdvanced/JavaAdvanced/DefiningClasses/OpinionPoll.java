package JavaAdvanced2021.JavaAdvanced.DefiningClassesExercises0410;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OpinionPoll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Person> listPerson = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] elementsPerson = scanner.nextLine().split("\\s+");
            String name = elementsPerson[0];
            int age = Integer.parseInt(elementsPerson[1]);
            Person person = new Person(name, age);
            listPerson.add(person);
        }
        listPerson.stream().filter(p -> p.getAge() > 30).sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }

    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return String.format("%s - %d", this.name, this.age);
        }
    }
}

