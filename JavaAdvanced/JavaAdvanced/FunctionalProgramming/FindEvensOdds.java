package JavaAdvanced2021.JavaAdvanced.FunctionalProgrammingLAB2809;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindEvensOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
          .mapToInt(Integer::parseInt).toArray();
        String format = scanner.nextLine();

        printNumber(input[0], input[1], format.equals("even") ? n -> n % 2 == 0 : n -> n % 2 != 0);
    }

    private static void printNumber(int start, int end, Predicate<Integer> predicate) {
        System.out.println(IntStream.rangeClosed(start, end).boxed().filter(predicate)
        .map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
