package JavaAdvancedExam;

import java.util.Scanner;

public class MatrixMouseCheese {
    public static int totalCheese = 5;
    public static int cheese = 0;
    public static int mRow = 0;
    public static int mCol = 0;
    public static boolean isValid = false;
    public static int mR = 0;
    public static int mC = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        for (int row = 0; row < matrix.length; row++) {
            String input = scanner.nextLine();
            matrix[row] = input.toCharArray();
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'M') {
                    mRow = row;
                    mCol = col;
                }
            }
        }
        mR = mRow;
        mC = mCol;
        int r = 0;
        int c = 0;

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            switch (command) {
                case "up":
                    r = mR;
                    c = mC;
                    mRow = r;
                    mCol = c;
                    move(matrix, mRow - 1, mCol, r, c, command);
                    break;
                case "down":
                    r = mR;
                    c = mC;
                    mRow = r;
                    mCol = c;
                    move(matrix, mRow + 1, mCol, r, c, command);
                    break;
                case "left":
                    r = mR;
                    c = mC;
                    mRow = r;
                    mCol = c;
                    move(matrix, mRow, mCol - 1, r, c, command);
                    break;
                case "right":
                    r = mR;
                    c = mC;
                    mRow = r;
                    mCol = c;
                    move(matrix, mRow, mCol + 1, r, c, command);
                    break;
            }

            if (isValid) {
                System.out.println("Where is the mouse?");
                break;
            }

            command = scanner.nextLine();
        }

        if (cheese >= totalCheese) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheese);
        }else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", totalCheese - cheese);
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + "");
            }
            System.out.println();
        }
    }

    private static void move(char[][] matrix, int mRow, int mCol, int r, int c, String command) {
        matrix[r][c] = '-';
        if (mouseValidIndex(matrix, mRow, mCol)) {
            isValid = true;
            return;
        }

        if (matrix[mRow][mCol] == 'B') {
            matrix[mRow][mCol] = '-';
            switch (command) {
                case "up":
                    mRow--;
                    break;
                case "down":
                    mRow++;
                    break;
                case "left":
                    mCol--;
                    break;
                case "right":
                    mCol++;
                    break;
            }
        }

        if (matrix[mRow][mCol] == 'c') {
            cheese++;
        }

        matrix[mRow][mCol] = 'M';

        mR = mRow;
        mC = mCol;
    }

    private static boolean mouseValidIndex(char[][] matrix, int r, int c) {
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length;
    }
}
