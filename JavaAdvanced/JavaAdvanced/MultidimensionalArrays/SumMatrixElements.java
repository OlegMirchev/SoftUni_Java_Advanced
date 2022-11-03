package JavaAdvanced2021.JavaAdvanced.MultidimensionalArraysLAB1709;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);

        System.out.println(printMatrix(matrix));
    }

    private static int printMatrix(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }
        }
        return sum;
    }

    private static int[][] readMatrix(Scanner scanner) {
      int[] rowCol = readArray(scanner);
      int row = rowCol[0];
      int col = rowCol[1];
        System.out.println(row);
        System.out.println(col);
      int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            matrix[i] = readArray(scanner);
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
    }
}
