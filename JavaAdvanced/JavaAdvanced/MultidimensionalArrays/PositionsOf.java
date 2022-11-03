package JavaAdvanced2021.JavaAdvanced.MultidimensionalArraysLAB1709;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);
        int number = Integer.parseInt(scanner.nextLine());
        boolean isValid = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentNumb = matrix[row][col];
                if (currentNumb == number) {
                    isValid = true;
                    System.out.println(row + " " + col);
                }
            }
        }
        if (!isValid) {
            System.out.println("not found");
        }
    }

    private static int[][] readMatrix(Scanner scanner) {
        int[] rowOrCol = readArray(scanner);
        int row = rowOrCol[0];
        int col = rowOrCol[1];
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            matrix[i] = readArray(scanner);
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
