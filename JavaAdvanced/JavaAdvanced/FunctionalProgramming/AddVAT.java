package JavaAdvanced2021.JavaAdvanced.FunctionalProgrammingLAB2809;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UnaryOperator<Double> vat = value -> value * 1.20;
        System.out.println("Prices with VAT:");

        Arrays.stream(scanner.nextLine().split(", ")).map(Double::parseDouble)
                .map(vat).forEach(result -> System.out.printf("%.2f%n", result));
    }
}
