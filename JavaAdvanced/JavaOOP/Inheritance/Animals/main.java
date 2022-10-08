package JavaAdvanced2021.JavaOPP.InheritanceExercises0411.Animals;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String typeAnimal = scanner.nextLine();

        while (!typeAnimal.equals("Beast!")) {
            String[] animalData = scanner.nextLine().split("\\s+");
            String name = animalData[0];
            int age = Integer.parseInt(animalData[1]);
            String gender = animalData[2];

            try {
                switch (typeAnimal) {
                    case "Cat":
                        Cat cat = new Cat(name, age, gender);
                        System.out.println(cat);
                        break;
                    case "Dog":
                        Dog dog = new Dog(name, age, gender);
                        System.out.println(dog);
                        break;
                    case "Frog":
                        Frog frog = new Frog(name, age, gender);
                        System.out.println(frog);
                        break;
                    case "Kitten":
                        Kitten kitten = new Kitten(name, age);
                        System.out.println(kitten);
                        break;
                    case "Tomcat":
                        Tomcat tomcat = new Tomcat(name, age);
                        System.out.println(tomcat);
                        break;
                }
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            typeAnimal = scanner.nextLine();
        }
    }
}
