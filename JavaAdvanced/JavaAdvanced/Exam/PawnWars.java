import java.util.Scanner;

public class PawnWars {
    public static int whiteRow = 0;
    public static int whiteCol = 0;
    public static int blackRow = 0;
    public static int blackCol = 0;
    public static String col = "";
    public static String row = "";
    public static String gameOver = "";
    public static boolean isValid = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputRow = 8;
        int inputCol = 8;

        char[][] matrix = readMatrix(scanner, inputRow, inputCol);

        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                if (matrix[rows][cols] == 'w') {
                    whiteRow = rows;
                    whiteCol = cols;
                }

                if (matrix[rows][cols] == 'b') {
                    blackRow = rows;
                    blackCol = cols;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            movePawnsOnChess(matrix, whiteRow, whiteCol, blackRow, blackCol);

            if (isValid) {
                break;
            }
        }

        System.out.println(gameOver);
    }

    public static void movePawnsOnChess(char[][] matrix, int wRow, int wCol, int bRow, int bCol) {

        if (isValidatedMoveWhitePawnRanks(matrix, wRow, wCol)) return;

        matrix[wRow][wCol] = '-';
        matrix[wRow - 1][wCol] = 'w';

        if (isValidatedMoveBlackPawnRanks(matrix, bRow, bCol)) return;

        matrix[bRow][bCol] = '-';
        matrix[bRow + 1][bCol] = 'b';

        whiteRow = wRow - 1;
        blackRow = bRow + 1;

        if (whiteRow == 0) {
            getRanksRow(whiteRow);
            getRanksCol(whiteCol);

            gameOver = String.format("Game over! White pawn is promoted to a queen at %s%s.", col, row);
            isValid = true;
            return;
        }

        if (blackRow == 7) {
            getRanksRow(blackRow);
            getRanksCol(blackCol);

            gameOver = String.format("Game over! Black pawn is promoted to a queen at %s%s.", col, row);
            isValid = true;
            return;
        }
    }

    public static boolean isValidatedMoveBlackPawnRanks(char[][] matrix, int bRow, int bCol) {
        if (bCol == 0) {
            if (matrix[bRow + 1][bCol + 1] == 'w') {
                getRanksRow(bRow + 1);

                if (matrix[bRow + 1][bCol + 1] == 'w') {
                    getRanksCol(bCol + 1);
                }

                gameOver = String.format("Game over! Black capture on %s%s.", col, row);
                isValid = true;
                return true;
            }
        } else if (bCol == 7) {
            if (matrix[bRow + 1][bCol - 1] == 'w') {
                getRanksRow(bRow + 1);

                if (matrix[bRow + 1][bCol - 1] == 'w') {
                    getRanksCol(bCol - 1);
                }

                gameOver = String.format("Game over! Black capture on %s%s.", col, row);
                isValid = true;
                return true;
            }
        } else if (matrix[bRow + 1][bCol - 1] == 'w' || matrix[bRow + 1][bCol + 1] == 'w') {
            getRanksRow(bRow + 1);

            if (matrix[bRow + 1][bCol - 1] == 'w') {
                getRanksCol(bCol - 1);
            } else if (matrix[bRow + 1][bCol + 1] == 'w') {
                getRanksCol(bCol + 1);
            }

            gameOver = String.format("Game over! Black capture on %s%s.", col, row);
            isValid = true;
            return true;
        }
        return false;
    }

    public static boolean isValidatedMoveWhitePawnRanks(char[][] matrix, int wRow, int wCol) {
        if (wCol == 0) {
            if (matrix[wRow - 1][wCol + 1] == 'b') {
                getRanksRow(wRow - 1);

                if (matrix[wRow - 1][wCol + 1] == 'b') {
                    getRanksCol(wCol + 1);
                }

                gameOver = String.format("Game over! White capture on %s%s.", col, row);
                isValid = true;
                return true;
            }
        } else if (wCol == 7) {
            if (matrix[wRow - 1][wCol - 1] == 'b') {
                getRanksRow(wRow - 1);

                if (matrix[wRow - 1][wCol - 1] == 'b') {
                    getRanksCol(wCol - 1);
                }

                gameOver = String.format("Game over! White capture on %s%s.", col, row);
                isValid = true;
                return true;
            }
        } else if (matrix[wRow - 1][wCol - 1] == 'b' || matrix[wRow - 1][wCol + 1] == 'b') {
            getRanksRow(wRow - 1);

            if (matrix[wRow - 1][wCol - 1] == 'b') {
                getRanksCol(wCol - 1);
            } else if (matrix[wRow - 1][wCol + 1] == 'b') {
                getRanksCol(wCol + 1);
            }

            gameOver = String.format("Game over! White capture on %s%s.", col, row);
            isValid = true;
            return true;
        }
        return false;
    }

    public static char[][] readMatrix(Scanner scanner, int row, int col) {
        char[][] matrix = new char[row][col];

        for (int rows = 0; rows < matrix.length; rows++) {
            matrix[rows] = scanner.nextLine().toCharArray();
        }

        return matrix;
    }

    public static void getRanksRow(int rows) {
        switch (rows) {
            case 0:
                row = "8";
                break;
            case 1:
                row = "7";
                break;
            case 2:
                row = "6";
                break;
            case 3:
                row = "5";
                break;
            case 4:
                row = "4";
                break;
            case 5:
                row = "3";
                break;
            case 6:
                row = "2";
                break;
            case 7:
                row = "1";
                break;
        }
    }

    public static void getRanksCol(int cols) {
        switch (cols) {
            case 0:
                col = "a";
                break;
            case 1:
                col = "b";
                break;
            case 2:
                col = "c";
                break;
            case 3:
                col = "d";
                break;
            case 4:
                col = "e";
                break;
            case 5:
                col = "f";
                break;
            case 6:
                col = "g";
                break;
            case 7:
                col = "h";
                break;
        }
    }
}
