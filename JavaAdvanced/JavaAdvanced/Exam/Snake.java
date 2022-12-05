package JavaAdvancedExam;

import java.util.Scanner;

public class Snake {
    public static int sRow = 0;
    public static int sCol = 0;
    public static int currentRow = 0;
    public static int currentCol = 0;
    public static final int ENOUGH_FOOD = 10;
    public static int food = 0;
    public static boolean isValidIndex = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = readMatrix(scanner, size);

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'S') {
                    sRow = row;
                    sCol = col;
                }
            }
        }
        currentRow = sRow;
        currentCol = sCol;


        while (food < ENOUGH_FOOD) {
            if (isValidIndex) {
                break;
            }

            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    moveMatrix(matrix,sRow - 1, sCol, currentRow, currentCol);
                    break;
                case "down":
                    moveMatrix(matrix, sRow + 1, sCol, currentRow, currentCol);
                    break;
                case "left":
                    moveMatrix(matrix, sRow, sCol - 1, currentRow, currentCol);
                    break;
                case "right":
                    moveMatrix(matrix, sRow, sCol + 1, currentRow, currentCol);
                    break;
            }
        }

        if (isValidIndex) {
            System.out.println("Game over!");
        }else {
            System.out.println("You won! You fed the snake.");
        }

        System.out.printf("Food eaten: %d%n", food);

        printMatrix(matrix);
    }

    private static void moveMatrix(char[][] matrix, int row, int col, int r, int c) {
        matrix[r][c] = '.';

        if (isBoundsEx(matrix, row, col)) {
            isValidIndex = true;
            return;
        }

        if (matrix[row][col] == 'B') {
            for (int rows = 0; rows < matrix.length; rows++) {
                for (int cols = 0; cols < matrix[rows].length; cols++) {
                    if (matrix[rows][cols] == 'B') {
                        matrix[row][col] = '.';
                        matrix[rows][cols] = 'S';
                        sRow = rows;
                        sCol = cols;
                        currentRow = rows;
                        currentCol = cols;
                    }
                }
            }
            return;
        }

        if (matrix[row][col] == '*') {
            food++;
        }

        matrix[row][col] = 'S';

        sRow = row;
        sCol = col;
        currentRow = row;
        currentCol = col;
    }

    private static boolean isBoundsEx(char[][] matrix, int row, int col) {
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
