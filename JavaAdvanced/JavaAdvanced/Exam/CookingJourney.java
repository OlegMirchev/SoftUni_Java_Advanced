package JavaAdvancedExam;

import java.util.Scanner;

public class CookingJourney {
    public static int cRow = 0;
    public static int cCol = 0;
    public static int currentRow = 0;
    public static int currentCol = 0;
    public static int money = 0;
    public static boolean isValid = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = readMatrix(scanner, size);

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'S') {
                    cRow = row;
                    cCol = col;
                }
            }
        }
        currentRow = cRow;
        currentCol = cCol;

        while (money < 50) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    move(matrix, cRow - 1, cCol, currentRow, currentCol);
                    break;
                case "down":
                    move(matrix, cRow + 1, cCol, currentRow, currentCol);
                    break;
                case "left":
                    move(matrix, cRow, cCol - 1, currentRow, currentCol);
                    break;
                case "right":
                    move(matrix, cRow, cCol + 1, currentRow, currentCol);
                    break;
            }

            if (isValid) {
                break;
            }
        }

        if (isValid) {
            System.out.println("Bad news! You are out of the pastry shop.");
        }else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.printf("Money: %d%n", money);

        printMatrixResult(matrix);
    }

    private static void move(char[][] matrix, int row, int col, int r, int c) {
        matrix[r][c] = '-';

        if (isValidIndex(matrix, row, col)) {
            isValid = true;
            return;
        }

        if (matrix[row][col] == 'P') {
            for (int rows = r; rows < matrix.length; rows++) {
                for (int cols = c; cols < matrix[rows].length; cols++) {
                    if (matrix[rows][cols] == 'P') {
                        matrix[rows][cols] = 'S';
                        matrix[row][col] = '-';
                        currentRow = rows;
                        currentCol = cols;
                        cRow = rows;
                        cCol = cols;
                    }
                }
            }
            return;
        }

        if (Character.isDigit(matrix[row][col])) {
            char n = matrix[row][col];
            money += Character.getNumericValue(n);
        }

        matrix[row][col] = 'S';

        currentRow = row;
        currentCol = col;
        cRow = row;
        cCol = col;
    }

    private static boolean isValidIndex(char[][] matrix, int row, int col) {
      return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    private static char[][] readMatrix(Scanner scanner, int size) {
        char[][] matrix = new char[size][size];

        for (int row = 0; row < matrix.length; row++) {
           String input = scanner.nextLine();
           matrix[row] = input.toCharArray();
        }
        return matrix;
    }

    private static void printMatrixResult(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
