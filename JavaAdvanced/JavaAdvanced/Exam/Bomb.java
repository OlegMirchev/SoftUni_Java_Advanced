package JavaAdvancedExam;

import java.util.Scanner;

public class Bomb {
    public static int bRow = 0;
    public static int bCol = 0;
    public static int countBomb = 0;
    public static int bombs = 0;
    public static boolean findBombs = false;
    public static boolean endRoute = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(",");

        char[][] matrix = readMatrix(scanner, size);

        findPositionAndAllBombs(matrix);

        for (String command : input) {

            switch (command) {
                case "up":
                    move(matrix, bRow - 1, bCol);
                    break;
                case "down":
                    move(matrix, bRow + 1, bCol);
                    break;
                case "left":
                    move(matrix, bRow, bCol - 1);
                    break;
                case "right":
                    move(matrix, bRow, bCol + 1);
                    break;
            }

            if (findBombs) {
                break;
            }else if (endRoute) {
                break;
            }
        }

        if (findBombs) {
            System.out.println("Congratulations! You found all bombs!");
        }else if (endRoute) {
            System.out.printf("END! %d bombs left on the field", bombs - countBomb);
        }else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombs - countBomb, bRow, bCol);
        }
    }

    private static void move(char[][] matrix, int row, int col) {

        if (isValidIndex(matrix, row, col)) {
            return;
        }

        if (matrix[row][col] == 'B') {
            countBomb++;
            matrix[row][col] = '+';
            System.out.println("You found a bomb!");
        }

        if (countBomb == bombs) {
            findBombs = true;
            return;
        }

        if (matrix[row][col] == 'e') {
            endRoute = true;
            return;
        }

        bRow = row;
        bCol = col;
    }

    private static void findPositionAndAllBombs(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 's') {
                    bRow = row;
                    bCol = col;
                }

                if (matrix[row][col] == 'B') {
                    bombs++;
                }
            }
        }
    }

    private static boolean isValidIndex(char[][] matrix, int row, int col) {
       return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    private static char[][] readMatrix(Scanner scanner, int size) {
        char[][] matrix = new char[size][size];

        for (int row = 0; row < matrix.length; row++) {
            String split = scanner.nextLine().replaceAll(" ", "");
            matrix[row] = split.toCharArray();
        }
        return matrix;
    }
}
