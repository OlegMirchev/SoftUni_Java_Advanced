package JavaAdvanced2021.JavaAdvanced.SetsAndMapsAdvancedExercises2309;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        Set<Integer> setN = new LinkedHashSet<>(n);
        Set<Integer> setM = new LinkedHashSet<>(m);

        for (int i = 1; i <= n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            setN.add(number);
        }
        for (int j = 1; j <= m; j++) {
            int number = Integer.parseInt(scanner.nextLine());
            setM.add(number);
        }
        setN.retainAll(setM);

        setN.forEach(result -> System.out.print(result + " "));
    }
}
