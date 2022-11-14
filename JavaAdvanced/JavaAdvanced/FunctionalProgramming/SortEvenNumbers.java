package JavaAdvanced2021.JavaAdvanced.FunctionalProgrammingLAB2809;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> number = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt)
                .filter(numb -> numb % 2 == 0).collect(Collectors.toList());

       String evenNumb = number.stream().map(String::valueOf)
                .collect(Collectors.joining(", "));

       System.out.println(evenNumb);

        String sortedNumb =  number.stream().sorted()
                .map(String::valueOf).collect(Collectors.joining(", "));

        System.out.println(sortedNumb);
    }
}
