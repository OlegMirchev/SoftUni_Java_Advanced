package JavaAdvanced2021.JavaAdvanced.MultidimensionalArraysExercises2009;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int rotation = Integer.parseInt(input.split("[()]+")[1]) % 360;
        String command = scanner.nextLine();
        List<String> inputMatrix = new ArrayList<>();
        int maxLength = command.length();

        while (!command.equals("END")) {
            inputMatrix.add(command);

            if (command.length() > maxLength) {
                maxLength = command.length();
            }

            command = scanner.nextLine();
        }
        int row = inputMatrix.size();
        int col = maxLength;
        char[][] matrix = new char[row][col];

        for (int rows = 0; rows < row; rows++) {
            for (int cols = 0; cols < col; cols++) {
                if (cols < inputMatrix.get(rows).length()) {
                    matrix[rows][cols] = inputMatrix.get(rows).charAt(cols);
                } else {
                    matrix[rows][cols] = ' ';
                }
            }
        }
        switch (rotation) {
            case 90:
                getOneRotation(matrix, row, col);
                break;
            case 180:
                getTwoRotation(matrix, row, col);
                break;
            case 270:
                getThreeRotation(matrix, row, col);
                break;
            default:
                printMatrix(matrix);
                break;
        }
    }

    private static void getOneRotation(char[][] matrix, int row, int col) {
        for (int cols = 0; cols < col; cols++) {
            for (int rows = row - 1; rows >= 0; rows--) {
                System.out.print(matrix[rows][cols]);
            }
            System.out.println();
        }
    }

    private static void getTwoRotation(char[][] matrix, int row, int col) {
        for (int rows = row - 1; rows >= 0; rows--) {
            for (int cols = col - 1; cols >= 0; cols--) {
                System.out.print(matrix[rows][cols]);
            }
            System.out.println();
        }
    }

    private static void getThreeRotation(char[][] matrix, int row, int col) {
        for (int cols = col - 1; cols >= 0; cols--) {
            for (int rows = 0; rows < row; rows++) {
                System.out.print(matrix[rows][cols]);
            }
            System.out.println();
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                System.out.print(matrix[rows][cols] + "");
            }
            System.out.println();
        }
    }
}
