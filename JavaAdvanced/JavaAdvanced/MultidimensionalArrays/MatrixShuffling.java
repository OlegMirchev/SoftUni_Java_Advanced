package JavaAdvanced2021.JavaAdvanced.MultidimensionalArraysExercises2009;

import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        scanner.nextLine();
        String[][] matrix = readMatrix(scanner, row, col);

        String command = scanner.nextLine();

        while (!command.equals("END")) {
            if (validateSwap(command, row, col)) {
                String[] input = command.split("\\s+");
                int rowFirst = Integer.parseInt(input[1]);
                int colFirst = Integer.parseInt(input[2]);
                int rowSecond = Integer.parseInt(input[3]);
                int colSecond = Integer.parseInt(input[4]);

                String number1 = matrix[rowFirst][colFirst];
                String number2 = matrix[rowSecond][colSecond];

                matrix[rowFirst][colFirst] = number2;
                matrix[rowSecond][colSecond] = number1;

                printMatrix(matrix);

            }else {
                System.out.println("Invalid input!");
                command = scanner.nextLine();
                continue;
            }

            command = scanner.nextLine();
        }
    }

    private static String[][] readMatrix(Scanner scanner, int row, int col) {
        String[][] matrix = new String[row][col];
        for (int rows = 0; rows < row; rows++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int cols = 0; cols < col; cols++) {
                matrix[rows][cols] = input[cols];
            }
        }
        return matrix;
    }

    private static boolean validateSwap(String command, int row, int col) {
        String[] input = command.split("\\s+");
        if (!input[0].equals("swap")) {
            return false;
        }
        if (input.length != 5) {
            return false;
        }
        int rowFirst = Integer.parseInt(input[1]);
        int colFirst = Integer.parseInt(input[2]);
        int rowSecond = Integer.parseInt(input[3]);
        int colSecond = Integer.parseInt(input[4]);

        if ((rowFirst < 0 || rowFirst >= row) || (colFirst < 0 || colFirst >= col)
                || (rowSecond < 0 || rowSecond >= row) || (colSecond < 0 || colSecond >= col)) {
            return false;
        }
        return true;
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
