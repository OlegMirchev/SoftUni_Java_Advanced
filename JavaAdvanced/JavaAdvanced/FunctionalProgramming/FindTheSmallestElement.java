package JavaAdvanced2021.JavaAdvanced.FunctionalProgrammingExercises3009;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> number = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());
        Consumer<List<Integer>> consumerNumbs = l -> {
            int min = Collections.min(l);
            System.out.println(l.lastIndexOf(min));
        };
        consumerNumbs.accept(number);
    }
}