package JavaAdvanced2021.JavaAdvanced.DefiningClassesExercises0410;

import java.util.*;

public class Google {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, Person> mapPerson = new LinkedHashMap<>();

        while (!command.equals("End")) {
            String[] input = command.split("\\s+");
            String namePerson = input[0];
            String newCommand = input[1];
            mapPerson.putIfAbsent(namePerson, new Person(namePerson, new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
            switch (newCommand) {
                case "company":
                    Company company = new Company(input[2], input[3], Double.parseDouble(input[4]));
                    mapPerson.get(namePerson).setCompany(company);
                    break;
                case "pokemon":
                    Pokemon pokemon = new Pokemon(input[2], input[3]);
                    mapPerson.get(namePerson).getListPokemon().add(pokemon);
                    break;
                case "parents":
                    Parents parents = new Parents(input[2], input[3]);
                    mapPerson.get(namePerson).getListParents().add(parents);
                    break;
                case "children":
                    Children children = new Children(input[2], input[3]);
                    mapPerson.get(namePerson).getListChildren().add(children);
                    break;
                case "car":
                    Car car = new Car(input[2], Integer.parseInt(input[3]));
                    mapPerson.get(namePerson).setCar(car);
                    break;

            }

            command = scanner.nextLine();
        }
        mapPerson.get(scanner.nextLine()).printResult();
    }

    public static class Person {
        private String name;
        private Company company;
        private List<Pokemon> listPokemon;
        private List<Parents> listParents;
        private List<Children> listChildren;
        private Car car;

        public void setCompany(Company company) {
            this.company = company;
        }

        public void setCar(Car car) {
            this.car = car;
        }

        public Person(String name, List<Pokemon> listPokemon, List<Parents> listParents, List<Children> listChildren) {
            this.name = name;
            this.listPokemon = listPokemon;
            this.listParents = listParents;
            this.listChildren = listChildren;
        }

        public List<Pokemon> getListPokemon() {
            return listPokemon;
        }

        public List<Parents> getListParents() {
            return listParents;
        }

        public List<Children> getListChildren() {
            return listChildren;
        }

        public void printResult() {
            System.out.println(this.name);
            System.out.println("Company:");
            if (this.company != null) {
                System.out.println(this.company.toString());
            }
            System.out.println("Car:");
            if (this.car != null) {
                System.out.println(this.car.toString());
            }
            System.out.println("Pokemon:");
            if (!getListPokemon().isEmpty()) {
                getListPokemon().forEach(p -> System.out.printf("%s%n", p.toString()));
            }
            System.out.println("Parents:");
            if (!getListParents().isEmpty()) {
                getListParents().forEach(p -> System.out.printf("%s%n", p.toString()));
            }
            System.out.println("Children:");
            if (!getListChildren().isEmpty()) {
                getListChildren().forEach(c -> System.out.printf("%s%n", c.toString()));
            }
        }
    }

    public static class Company {
        private String name;
        private String department;
        private double salary;

        public Company(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return String.format("%s %s %.2f", this.name, this.department, this.salary);
        }
    }

    public static class Pokemon {
        private String name;
        private String type;

        public Pokemon(String name, String type) {
            this.name = name;
            this.type = type;
        }

        @Override
        public String toString() {
            return String.format("%s %s", this.name, this.type);
        }
    }

    public static class Parents {
        private String name;
        private String birthday;

        public Parents(String name, String birthday) {
            this.name = name;
            this.birthday = birthday;
        }

        @Override
        public String toString() {
            return String.format("%s %s", this.name, this.birthday);
        }
    }

    public static class Children {
        private String name;
        private String birthday;

        public Children(String name, String birthday) {
            this.name = name;
            this.birthday = birthday;
        }

        @Override
        public String toString() {
            return String.format("%s %s", this.name, this.birthday);
        }
    }

    public static class Car {
        private String model;
        private int power;

        public Car(String model, int power) {
            this.model = model;
            this.power = power;
        }

        @Override
        public String toString() {
            return String.format("%s %d", this.model, this.power);
        }
    }
}


