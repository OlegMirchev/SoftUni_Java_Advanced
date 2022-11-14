package JavaAdvanced2021.JavaAdvanced.FunctionalProgrammingLAB2809;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
          .map(Integer::parseInt).collect(Collectors.toList());

        System.out.println("Count = " + numbers.size());

        int sum = numbers.stream().mapToInt(Integer::valueOf).sum();

        System.out.println("Sum = " + sum);

    }
}
