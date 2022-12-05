package JavaAdvancedExam;

import java.util.Scanner;

public class ThroneConquering {
    public static int tRow = 0;
    public static int tCol = 0;
    public static int currentRow = 0;
    public static int currentCol = 0;
    public static int energy = 0;
    public static int enemyRow = 0;
    public static int enemyCol = 0;
    public static boolean indexHelen = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        energy = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = readMatrix(scanner, size);

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'P') {
                    tRow = row;
                    tCol = col;
                }
            }
        }
        currentRow = tRow;
        currentCol = tCol;

        while (energy > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            enemyRow = Integer.parseInt(input[1]);
            enemyCol = Integer.parseInt(input[2]);

            switch (command) {
                case "up":
                    moveSparta(matrix, tRow - 1, tCol, currentRow, currentCol, enemyRow, enemyCol);
                    break;
                case "down":
                    moveSparta(matrix, tRow + 1, tCol, currentRow, currentCol, enemyRow, enemyCol);
                    break;
                case "left":
                    moveSparta(matrix, tRow, tCol - 1, currentRow, currentCol, enemyRow, enemyCol);
                    break;
                case "right":
                    moveSparta(matrix, tRow, tCol + 1, currentRow, currentCol, enemyRow, enemyCol);
                    break;
            }

            if (indexHelen) {
                break;
            }
        }

        if (indexHelen) {
            System.out.println("Paris has successfully abducted Helen! Energy left: " + energy);
        }else {
            System.out.printf("Paris died at %d;%d.%n", enemyRow, enemyCol);
        }

        printMatrix(matrix);
    }

    private static void moveSparta(char[][] matrix, int row, int col, int r, int c, int rowS, int colS) {
        matrix[r][c] = '-';

        energy--;

        matrix[rowS][colS] = 'S';

        if (isValidIndexField(matrix, row, col)) {
            row = r;
            col = c;
        }

        if (matrix[row][col] == 'S') {
            energy -= 2;
        }

        if (matrix[row][col] == 'H') {
            indexHelen = true;
            matrix[row][col] = '-';
            return;
        }

        if (energy <= 0) {
            matrix[row][col] = 'X';
            enemyRow = row;
            enemyCol = col;
            return;
        }

        matrix[row][col] = 'P';

        tRow = row;
        tCol = col;
        currentRow = row;
        currentCol = col;

    }

    private static boolean isValidIndexField(char[][] matrix, int row, int col) {
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
