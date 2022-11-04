package JavaAdvanced2021.JavaAdvanced.MultidimensionalArraysExercises2009;

import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine());
        int col = row;
        int[][] matrix = readMatrix(scanner, row, col);

        int sumPrimaryDiagonal = getSumPrimaryDiagonal(matrix, row, col);
        int sumSecondaryDiagonal = getSumSecondaryDiagonal(matrix, row, col);

        System.out.println(Math.abs(sumPrimaryDiagonal - sumSecondaryDiagonal));
    }

    private static int[][] readMatrix(Scanner scanner, int row, int col) {
        int[][] matrix = new int[row][col];
        for (int rows = 0; rows < row; rows++) {
            String[] number = scanner.nextLine().split("\\s+");
            for (int cols = 0; cols < col; cols++) {
                matrix[rows][cols] = Integer.parseInt(number[cols]);
            }
        }
        return matrix;
    }

    private static int getSumPrimaryDiagonal(int[][] matrix, int row, int col) {
        int sum = 0;
        for (int rows = 0; rows < row; rows++) {
            for (int cols = 0; cols < col; cols++) {
                if (rows == cols) {
                    sum += matrix[rows][cols];
                }
            }
        }
        return sum;
    }

    private static int getSumSecondaryDiagonal(int[][] matrix, int row, int col) {
        int sum = 0;
        for (int rows = row - 1; rows >= 0; rows--) {
            for (int cols = 0; cols < col; cols++) {
                if ((rows + cols) == (col - 1)){
                    sum += matrix[rows][cols];
                }
            }
        }
        return sum;
    }
}

