package JavaAdvancedExam;

import java.util.Scanner;

public class Python {
    public static int sRow = 0;
    public static int sCol = 0;
    public static int currentRow = 0;
    public static int currentCol = 0;
    public static int lengthSnake = 1;
    public static int countFood = 0;
    public static boolean isFoundEnemy = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(", ");

        char[][] matrix = readMatrix(scanner, size);

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 's') {
                    sRow = row;
                    sCol = col;
                }

                if (matrix[row][col] == 'f') {
                    countFood++;
                }
            }
        }
        currentRow = sRow;
        currentCol = sCol;

        for (String command : input) {
            switch (command) {
                case "up":
                    moveSnake(matrix, sRow - 1, sCol, currentRow, currentCol);
                    break;
                case "down":
                    moveSnake(matrix, sRow + 1, sCol, currentRow, currentCol);
                    break;
                case "left":
                    moveSnake(matrix, sRow, sCol - 1, currentRow, currentCol);
                    break;
                case "right":
                    moveSnake(matrix, sRow, sCol + 1, currentRow, currentCol);
                    break;
            }

            if (isFoundEnemy || countFood == 0) {
                break;
            }
        }

        if (countFood == 0) {
            System.out.println("You win! Final python length is " + lengthSnake);
        }else if (isFoundEnemy) {
            System.out.println("You lose! Killed by an enemy!");
        }else {
            System.out.printf("You lose! There is still %d food to be eaten.", countFood);
        }
    }

    private static void moveSnake(char[][] matrix, int row, int col, int r, int c) {
        matrix[r][c] = '*';

        if (isValidIndex(matrix, row, col)) {
            if (row < 0) {
                row = matrix.length - 1;
            }else if (row >= matrix.length) {
                row = 0;
            }else if (col < 0) {
                col = matrix[row].length - 1;
            }else if (col >= matrix[row].length) {
                col = 0;
            }
        }

        if (matrix[row][col] == 'e') {
           isFoundEnemy = true;
           return;
        }

        if (matrix[row][col] == 'f') {
            lengthSnake++;
            countFood--;
        }

        matrix[row][col] = 's';

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
            String[] input = scanner.nextLine().split(" ");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = input[col].charAt(0);
            }
        }

        return matrix;
    }
}
