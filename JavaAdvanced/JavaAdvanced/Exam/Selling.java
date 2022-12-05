package JavaAdvancedExam;

import java.util.Scanner;

public class Selling {
    public static int money = 0;
    public static int sRow = 0;
    public static int sCol = 0;
    public static int currentRow = 0;
    public static int currentCol = 0;
    public static boolean isValid = false;

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

        while (money < 50) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    move(matrix, sRow - 1, sCol, currentRow, currentCol);
                    break;
                case "down":
                    move(matrix, sRow + 1, sCol, currentRow, currentCol);
                    break;
                case "left":
                    move(matrix, sRow, sCol - 1, currentRow, currentCol);
                    break;
                case "right":
                    move(matrix, sRow, sCol + 1, currentRow, currentCol);
                    break;
            }
            if (isValid) {
                break;
            }
        }

        if (isValid) {
            System.out.println("Bad news, you are out of the bakery.");
        }else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.println("Money: " + money);

        printMatrix(matrix);
    }

    private static void move(char[][] matrix, int row, int col, int r, int c) {
        matrix[r][c] = '-';

        if (isValidIndex(matrix, row, col)) {
            isValid = true;
            return;
        }

        if (matrix[row][col] == 'O') {
            for (int rows = 0; rows < matrix.length; rows++) {
                for (int cols = 0; cols < matrix[rows].length; cols++) {
                    if (matrix[rows][cols] == 'O') {
                        matrix[rows][cols] = 'S';
                        matrix[rows][cols] = '-';
                        sRow = rows;
                        sCol = cols;
                        currentRow = rows;
                        currentCol = cols;
                    }
                }
            }
            return;
        }

        if (Character.isDigit(matrix[row][col])) {
            money += Character.getNumericValue(matrix[row][col]);
        }

        matrix[row][col] = 'S';

        sRow = row;
        sCol = col;
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
