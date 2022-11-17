package JavaAdvanced2021.JavaAdvanced.FunctionalProgrammingExercises3009;

import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        Consumer<String> printName = name -> System.out.println("Sir " + name);
        for (String result : input) {
            printName.accept(result);
        }
    }
}
