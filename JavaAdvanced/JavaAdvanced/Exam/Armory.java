import java.util.Scanner;

public class Armory {
    public static int rowA = 0;
    public static int colA = 0;
    public static int aRow = 0;
    public static int aCol = 0;
    public static int swordsSum = 0;
    public static int goldCoins = 65;
    public static boolean isValid = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = readMatrix(scanner, size);

        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                if (matrix[rows][cols] == 'A') {
                    rowA = rows;
                    colA = cols;
                }
            }
        }
        aRow = rowA;
        aCol = colA;

        while (swordsSum < goldCoins) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    moveArmory(matrix, rowA - 1, colA, aRow, aCol);
                    break;
                case "down":
                    moveArmory(matrix, rowA + 1, colA, aRow, aCol);
                    break;
                case "left":
                    moveArmory(matrix, rowA, colA - 1, aRow, aCol);
                    break;
                case "right":
                    moveArmory(matrix, rowA, colA + 1, aRow, aCol);
                    break;
            }

            if (isValid) {
                break;
            }
        }

        if (isValid) {
            System.out.println("I do not need more swords!");
        }else {
            System.out.println("Very nice swords, I will come back for more!");
        }

        System.out.printf("The king paid %d gold coins.%n", swordsSum);

        printMatrix(matrix);
    }


    public static void moveArmory(char[][] matrix, int row, int col, int oldRow, int oldCol) {
        matrix[oldRow][oldCol] = '-';

        if (isValidIndex(matrix, row, col)) {
            isValid = true;
            return;
        }

        if (matrix[row][col] == 'M') {
            matrix[row][col] = '-';

            for (int rows = 0; rows < matrix.length; rows++) {
                for (int cols = 0; cols < matrix[rows].length; cols++) {
                    if (matrix[rows][cols] == 'M') {
                        matrix[rows][cols] = 'A';
                        rowA = rows;
                        colA = cols;
                        aRow = rows;
                        aCol = cols;
                        return;
                    }
                }
            }
        }

        if (Character.isDigit(matrix[row][col])) {
            int price = Integer.parseInt(String.valueOf(matrix[row][col]));
            swordsSum += price;
        }

        matrix[row][col] = 'A';

        rowA = row;
        colA = col;
        aRow = row;
        aCol = col;
    }

    public static boolean isValidIndex(char[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    public static char[][] readMatrix(Scanner scanner, int size) {
        char[][] matrix = new char[size][size];

        for (int rows = 0; rows < matrix.length; rows++) {
            matrix[rows] = scanner.nextLine().toCharArray();
        }

        return matrix;
    }

    public static void printMatrix(char[][] matrix) {
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                System.out.print(matrix[rows][cols]);
            }

            System.out.println();
        }
    }
}
