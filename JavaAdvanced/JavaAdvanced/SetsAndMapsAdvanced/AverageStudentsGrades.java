package JavaAdvanced2021.JavaAdvanced.SetsAndMapsAdvancedLAB2109;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> mapGrade = new TreeMap<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String nameStudent = input[0];
            double grade = Double.parseDouble(input[1]);

            if (!mapGrade.containsKey(nameStudent)) {
                mapGrade.put(nameStudent, new ArrayList<>());
                mapGrade.get(nameStudent).add(grade);
            }else {
                mapGrade.get(nameStudent).add(grade);
            }
        }
        mapGrade.forEach((key, value) -> {
            double average = 0.0;
            for (Double grade : value) {
                average += grade;
            }
            average /= value.size();
            System.out.printf("%s -> ", key);
            value.forEach(result -> System.out.printf("%.2f ", result));
            System.out.printf("(avg: %.2f)%n", average);

        });
    }
}
