package JavaAdvanced2021.JavaOPP.WorkingWithAbstractionLAB2610.PointInRectangle;

import java.util.*;

public class main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rectanglePoints = Arrays.stream(scanner.nextLine().split("\\s+"))
          .mapToInt(Integer::parseInt).toArray();
        Point A = new Point(rectanglePoints[0], rectanglePoints[1]);
        Point B = new Point(rectanglePoints[2], rectanglePoints[3]);

        Rectangle rectangle = new Rectangle(A, B);

        String[] input = scanner.nextLine().split("\\s+");

        for (int i = 1; i <= Integer.parseInt(input[0]); i++) {
            int[] points = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            Point p = new Point(points[0], points[1]);

            boolean isValid = rectangle.contains(p);

            System.out.println(isValid);
        }
    }
}


