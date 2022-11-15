package JavaAdvanced2021.JavaAdvanced.FunctionalProgrammingExercises3009;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
          .mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();
        Function<int[], int[]> addNumb = arr -> Arrays.stream(arr).map(n -> n += 1).toArray();
        Function<int[], int[]> multiplyNumb = arr -> Arrays.stream(arr).map(n -> n *= 2).toArray();
        Function<int[], int[]> subtractNumb = arr -> Arrays.stream(arr).map(n -> n -= 1).toArray();
        Consumer<int[]> printNumb = arr -> Arrays.stream(arr).forEach(n -> System.out.print(n + " "));

        while (!command.equals("end")) {
            switch (command) {
                case "add":
                   numbers = addNumb.apply(numbers);
                    break;
                case "multiply":
                   numbers = multiplyNumb.apply(numbers);
                    break;
                case "subtract":
                   numbers = subtractNumb.apply(numbers);
                    break;
                case "print":
                    printNumb.accept(numbers);
                    System.out.println();
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
