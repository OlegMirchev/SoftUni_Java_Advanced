package JavaAdvanced2021.JavaAdvanced.MultidimensionalArraysLAB1709;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());

        int[][]matrix = readMatrix(rows, 0, scanner);
        int[] wrongCoordinates = readArray(scanner);
        int wrongNumb = matrix[wrongCoordinates[0]][wrongCoordinates[1]];
        List<int[]> updateNumbs = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongNumb) {
                    updateNumbs.add(new int[] {row, col, getSumWithOutWrongNumb(row, col, matrix, wrongNumb)});
                }
            }
        }
        for (int[] result : updateNumbs) {
            matrix[result[0]][result[1]] = result[2];
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }

    private static int[][] readMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner);
        }
        return matrix;
    }

    private static int getSumWithOutWrongNumb(int row, int col, int[][] matrix, int wrongNumb) {
        int sum = 0;
        if (col + 1 < matrix[row].length && matrix[row][col + 1] != wrongNumb) {
           sum += matrix[row][col + 1];
        }
        if (col - 1 >= 0 && matrix[row][col - 1] != wrongNumb) {
            sum += matrix[row][col - 1];
        }
        if (row + 1 < matrix.length && matrix[row + 1][col] != wrongNumb) {
            sum += matrix[row + 1][col];
        }
        if (row - 1 >= 0 && matrix[row - 1][col] != wrongNumb) {
            sum += matrix[row - 1][col];
        }
        return sum;
    }
}
