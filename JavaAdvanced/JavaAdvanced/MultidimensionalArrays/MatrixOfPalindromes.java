package JavaAdvanced2021.JavaAdvanced.MultidimensionalArraysExercises2009;

import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        String[][] matrixPalindrome = new String[row][col];
        char startLetter = 'a';

        for (int rows = 0; rows < row; rows++) {
            for (int cols = 0; cols < col; cols++) {
                matrixPalindrome[rows][cols] = "" + startLetter + (char) (startLetter + cols) + startLetter;
            }
            startLetter = (char)(startLetter + 1);
        }
        printMatrix(matrixPalindrome);
    }

    private static void printMatrix(String[][] matrix) {
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                System.out.print(matrix[rows][cols] + " ");
            }
            System.out.println();
        }
    }
}
