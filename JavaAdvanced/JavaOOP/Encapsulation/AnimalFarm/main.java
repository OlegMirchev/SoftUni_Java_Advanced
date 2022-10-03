package JavaAdvanced2021.JavaOPP.EncapsulationExercises0111.AnimalFarm;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        try {
            Chicken chicken = new Chicken(name, age);
            System.out.println(chicken.toString());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static class Chicken {
        private String name;
        private int age;

        public Chicken(String name, int age) {
            this.setName(name);
            this.setAge(age);
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        private void setName(String name) {
            name = name.trim();
            if (name.isEmpty() || name == null) {
                throw new IllegalArgumentException("Name cannot be empty.");
            }
            this.name = name;
        }

        private void setAge(int age) {
            if (age < 0 || age > 15) {
                throw new IllegalArgumentException("Age should be between 0 and 15.");
            }
            this.age = age;
        }

        private double calculateProductPerDay() {
            if (this.age < 6) {
                return 2;
            } else if (this.age < 12) {
                return 1;
            } else {
                return 0.75;
            }
        }

        public double productPerDay() {
            return calculateProductPerDay();
        }

        @Override
        public String toString() {
            return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", this.name, this.age, productPerDay());
        }
    }
}
