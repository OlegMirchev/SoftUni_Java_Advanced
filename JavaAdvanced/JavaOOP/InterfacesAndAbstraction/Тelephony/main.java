package JavaAdvanced2021.JavaOPP.InterfacesAndAbstractionExercises0811.Тelephony;

import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split("\\s+");
        String[] urls = scanner.nextLine().split("\\s+");

        Smartphone smartphone = new Smartphone(List.of(numbers), List.of(urls));

        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());
    }
}
