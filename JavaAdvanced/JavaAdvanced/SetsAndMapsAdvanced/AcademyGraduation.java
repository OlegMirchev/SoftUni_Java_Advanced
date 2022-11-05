package JavaAdvanced2021.JavaAdvanced.SetsAndMapsAdvancedLAB2109;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, double[]> mapGraduated = new TreeMap<>();

        for (int i = 1; i <= n; i++) {
            String nameStudent = scanner.nextLine();
            double[] grade = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble)
                    .toArray();

            mapGraduated.put(nameStudent, grade);
        }
        mapGraduated.forEach((key, value) -> {
            double average = Arrays.stream(value).average().orElse(0);
            DecimalFormat avrGrade = new DecimalFormat("#0.000");
            System.out.println(key + "is graduated with " + avrGrade.format(average));
            //System.out.printf("%s is graduated with %f%n", key, avrGrade.format(average));
        });
    }
}
