package JavaAdvanced2021.JavaAdvanced.FunctionalProgrammingLAB2809;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        Predicate<String> predicate = letter ->
                Character.isUpperCase(letter.charAt(0));

        List<String> upperCase = Arrays.stream(input).filter(predicate).collect(Collectors.toList());

        System.out.println(upperCase.size());
        upperCase.forEach(System.out::println);
    }
}
