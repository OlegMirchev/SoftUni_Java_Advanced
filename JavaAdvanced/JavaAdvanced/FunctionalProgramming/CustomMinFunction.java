package JavaAdvanced2021.JavaAdvanced.FunctionalProgrammingExercises3009;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //List<Integer> number = Arrays.stream(scanner.nextLine().split("\\s+"))
        //  .map(Integer::parseInt).collect(Collectors.toList());
        //int a = Collections.min(number);
        //System.out.println(a);

        List<Integer> number = Arrays.stream(scanner.nextLine().split("\\s+"))
          .map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> minNumbs = listNumb -> Collections.min(number);
        System.out.println(minNumbs.apply(number));

    }
}
