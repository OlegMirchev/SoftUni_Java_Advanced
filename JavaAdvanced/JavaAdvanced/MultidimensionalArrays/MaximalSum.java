package JavaAdvanced2021.JavaAdvanced.MultidimensionalArraysExercises2009;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        int max = Integer.MIN_VALUE;
        int bestRows = 0;
        int bestCols = 0;

        for (int rows = 0; rows < matrix.length - 2; rows++) {
            for (int cols = 0; cols < matrix[rows].length - 2; cols++) {
                int sum = 0;
                sum += matrix[rows][cols] + matrix[rows][cols + 1] + matrix[rows][cols + 2];
                sum += matrix[rows + 1][cols] + matrix[rows + 1][cols + 1] + matrix[rows + 1][cols + 2];
                sum += matrix[rows + 2][cols] + matrix[rows + 2][cols + 1] + matrix[rows + 2][cols + 2];

                if (sum > max) {
                    max = sum;
                    bestRows = rows;
                    bestCols = cols;
                }
            }
        }
        printMatrix(matrix, max, bestRows, bestCols);
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }

    private static int[][] readMatrix(Scanner scanner) {
        int[] rowsCols = readArray(scanner);
        int row = rowsCols[0];
        int col = rowsCols[1];
        int[][] matrix = new int[row][col];
        for (int rows = 0; rows < matrix.length; rows++) {
            matrix[rows] = readArray(scanner);
        }
        return matrix;
    }
    private static void printMatrix(int[][] matrix, int max, int bestRows, int bestCols) {
        System.out.printf("Sum = %d%n", max);
        for (int rows = bestRows; rows < bestRows + 3; rows++) {
            for (int cols = bestCols; cols < bestCols + 3; cols++) {
                System.out.print(matrix[rows][cols] + " ");
            }
            System.out.println();
        }
    }
}
