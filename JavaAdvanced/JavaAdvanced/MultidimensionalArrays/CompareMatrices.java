package JavaAdvanced2021.JavaAdvanced.MultidimensionalArraysLAB1709;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);

        if (printAreOrNotEqual(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        }else {
            System.out.println("not equal");
        }
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static int[][] readMatrix(Scanner scanner) {
        int[] rowsAndCols = readArray(scanner);
        int row = rowsAndCols[0];
        int col = rowsAndCols[1];
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            matrix[i] = readArray(scanner);
        }

        return matrix;
    }

    private static boolean printAreOrNotEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            int[] arrayOne = firstMatrix[row];
            int[] arrayTwo = secondMatrix[row];

            if (arrayOne.length != arrayTwo.length) {
                return false;
            }
            for (int col = 0; col < arrayOne.length; col++) {
                if (arrayOne[col] != arrayTwo[col]) {
                    return false;
                }
            }
        }
        return true;
    }
}
