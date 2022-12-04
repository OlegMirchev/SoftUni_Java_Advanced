package JavaAdvancedExam;

import java.util.Scanner;

public class PresentDelivery {
    public static int pRow = 0;
    public static int pCol = 0;
    public static int currentRow = 0;
    public static int currentCol = 0;
    public static int niceKids = 0;
    public static int countVofMatrix = 0;
    public static int dropPresent = 0;
    public static boolean isValid = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        dropPresent = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = readMatrix(scanner, size);

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'S') {
                    pRow = row;
                    pCol = col;
                }
            }
        }

        countVofMatrix = findCountV(matrix);

        currentRow = pRow;
        currentCol = pCol;

        while (dropPresent > 0) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    moveMatrix(matrix, pRow - 1, pCol, currentRow, currentCol);
                    break;
                case "down":
                    moveMatrix(matrix, pRow + 1, pCol, currentRow, currentCol);
                    break;
                case "left":
                    moveMatrix(matrix, pRow, pCol - 1, currentRow, currentCol);
                    break;
                case "right":
                    moveMatrix(matrix, pRow, pCol + 1, currentRow, currentCol);
                    break;
            }

            if (command.equals("Christmas morning") || isValid) {
                break;
            }
        }

        if (dropPresent == 0 || isValid) {
            System.out.println("Santa ran out of presents!");
        }

        printMatrix(matrix);

        if (niceKids == countVofMatrix) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", niceKids);
        }else {
            countVofMatrix = 0;
            System.out.printf("No presents for %d nice kid/s.", findCountV(matrix));
        }
    }

    private static void moveMatrix(char[][] matrix, int row, int col, int r, int c) {
        matrix[r][c] = '-';

        if (isValidIndex(matrix, row, col)) {
            isValid = true;
        }

        if (matrix[row][col] == 'V') {
            niceKids++;
            dropPresent--;
        }

        if (matrix[row][col] == 'C') {
            if (matrix[row - 1][col] == 'X') {
                dropPresent--;
                matrix[row - 1][col] = '-';
            }else if (matrix[row - 1][col] == 'V') {
                niceKids++;
                dropPresent--;
                matrix[row - 1][col] = '-';
            }
            if (matrix[row + 1][col] == 'X') {
                dropPresent--;
                matrix[row + 1][col] = '-';
            }else if (matrix[row + 1][col] == 'V') {
                niceKids++;
                dropPresent--;
                matrix[row + 1][col] = '-';
            }
            if (matrix[row][col - 1] == 'X') {
                dropPresent--;
                matrix[row][col - 1] = '-';
            }else if (matrix[row][col - 1] == 'V') {
                niceKids++;
                dropPresent--;
                matrix[row][col - 1] = '-';
            }
            if (matrix[row][col + 1] == 'X') {
                dropPresent--;
                matrix[row][col + 1] = '-';
            }else if (matrix[row][col + 1] == 'V') {
                niceKids++;
                dropPresent--;
                matrix[row][col + 1] = '-';
            }
        }

        matrix[row][col] = 'S';

        pRow = row;
        pCol = col;
        currentRow = row;
        currentCol = col;
    }

    private static boolean isValidIndex(char[][] matrix, int row, int col) {
       return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    private static int findCountV(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'V') {
                    countVofMatrix++;
                }
            }
        }
        return countVofMatrix;
    }

    private static char[][] readMatrix(Scanner scanner, int size) {
        char[][] matrix = new char[size][size];

        for (int row = 0; row < matrix.length; row++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = input[col].charAt(0);
            }
        }
        return matrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
