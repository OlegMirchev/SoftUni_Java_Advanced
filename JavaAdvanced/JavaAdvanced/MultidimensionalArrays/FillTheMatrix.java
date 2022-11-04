package JavaAdvanced2021.JavaAdvanced.MultidimensionalArraysExercises2009;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int row = Integer.parseInt(input[0]);
        String pattern = input[1];
        int col = row;
        int[][] matrix = new int[row][col];

        if (pattern.equals("A")) {
            fillPatternA(matrix, row, col);
        }else if (pattern.equals("B")) {
            fillPatternB(matrix, row, col);
        }
        printMatrix(matrix);
    }

    private static void fillPatternA(int[][] matrix, int row, int col) {
        int startNumb = 1;
        for (int cols = 0; cols < col; cols++) {
            for (int rows = 0; rows < row; rows++) {
                matrix[rows][cols] = startNumb;
                startNumb++;
            }
        }
    }

    private static void fillPatternB(int[][] matrix, int row, int col) {
        int startNumb = 1;
        for (int cols = 0; cols < col; cols++) {
            if (cols % 2 == 0) {
                for (int rows = 0; rows < row; rows++) {
                    matrix[rows][cols] = startNumb;
                    startNumb++;
                }
            }else {
                for (int rows = row - 1; rows >= 0; rows--) {
                    matrix[rows][cols] = startNumb;
                    startNumb++;
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                System.out.print(matrix[rows][cols] + " ");
            }
            System.out.println();
        }
    }
}
