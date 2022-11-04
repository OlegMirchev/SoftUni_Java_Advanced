package JavaAdvanced2021.JavaAdvanced.MultidimensionalArraysExercises2009;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);

        List<List<Integer>> listMatrix = new ArrayList<>();
        readMatrix(listMatrix, row, col);
        String command = scanner.nextLine();

        while (!command.equals("Nuke it from orbit")) {
            String[] newCommand = command.split("\\s+");
            int rows = Integer.parseInt(newCommand[0]);
            int cols = Integer.parseInt(newCommand[1]);
            int radius = Integer.parseInt(newCommand[2]);

            for (int currentRow = rows - radius; currentRow <= rows + radius; currentRow++) {
                if (validMatrix(listMatrix, currentRow, cols) && currentRow != rows) {
                    listMatrix.get(currentRow).remove(cols);
                }
            }
            for (int currentCol = cols + radius; currentCol >= cols - radius; currentCol--) {
                if (validMatrix(listMatrix, rows, currentCol)) {
                    listMatrix.get(rows).remove(currentCol);
                }
            }
            listMatrix.removeIf(List::isEmpty);

            command = scanner.nextLine();
        }
        printMatrix(listMatrix);
    }

    private static void readMatrix(List<List<Integer>> listMatrix, int row, int col) {
        int startNumber = 1;
        for (int rows = 0; rows < row; rows++) {
            listMatrix.add(new ArrayList<>());
            for (int cols = 0; cols < col; cols++) {
                listMatrix.get(rows).add(startNumber);
                startNumber++;
            }
        }
    }

    private static boolean validMatrix(List<List<Integer>> listMatrix, int rows, int cols) {
        return rows >= 0 && rows < listMatrix.size() && cols >= 0 && cols < listMatrix.get(rows).size();
    }

    private static void printMatrix(List<List<Integer>> listMatrix) {
        for (List<Integer> matrixResultRow : listMatrix) {
            for (Integer matrixResultCol : matrixResultRow) {
                System.out.print(matrixResultCol + " ");
            }
            System.out.println();
        }
    }
}
