package JavaAdvancedExam;

import java.util.Scanner;

public class Bee {
    public static int bRow = 0;
    public static int bCol = 0;
    public static int currentRow = 0;
    public static int currentCol = 0;
    public static int flowers = 0;
    public static final int pollinatedFlowers = 5;
    public static boolean isValid = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = readMatrix(scanner, size);

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'B') {
                    bRow = row;
                    bCol = col;
                }
            }
        }
        currentRow = bRow;
        currentCol = bCol;

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            switch (command) {
                case "up":
                    move(matrix, bRow - 1, bCol, currentRow, currentCol, command);
                    break;
                case "down":
                    move(matrix, bRow + 1, bCol, currentRow, currentCol, command);
                    break;
                case "left":
                    move(matrix, bRow, bCol - 1, currentRow, currentCol, command);
                    break;
                case "right":
                    move(matrix, bRow, bCol + 1, currentRow, currentCol, command);
                    break;
            }

            if (isValid) {
                System.out.println("The bee got lost!");
                break;
            }

            command = scanner.nextLine();
        }

        if (flowers >= pollinatedFlowers) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", flowers);
        }else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", pollinatedFlowers - flowers);
        }

        printMatrix(matrix);
    }

    private static void move(char[][] matrix, int row, int col, int r, int c, String command) {
        matrix[r][c] = '.';

        if (isValidIndex(matrix, row, col)) {
            isValid = true;
            return;
        }

        if (matrix[row][col] == 'O') {
            matrix[row][col] = '.';
            switch (command) {
                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
                case "left":
                    col--;
                    break;
                case "right":
                    col++;
                    break;
            }
        }

        if (matrix[row][col] == 'f') {
            flowers++;
        }

        matrix[row][col] = 'B';

        bRow = row;
        bCol = col;
        currentRow = row;
        currentCol = col;
    }

    private static boolean isValidIndex(char[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    private static char[][] readMatrix(Scanner scanner, int size) {
        char[][] matrix = new char[size][size];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }

        return matrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
