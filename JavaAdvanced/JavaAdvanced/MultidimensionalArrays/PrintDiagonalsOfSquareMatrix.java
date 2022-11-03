package JavaAdvanced2021.JavaAdvanced.MultidimensionalArraysLAB1709;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readMatrix(row, scanner);


        List<Integer> firstDiagonal = new ArrayList<>();
        List<Integer> secondDiagonal = new ArrayList<>();
        int firstRowDiagonal = 0;
        int secondRowDiagonal = row - 1;
        for (int rows = 0; rows < matrix.length; rows++) {
            firstDiagonal.add(matrix[rows][firstRowDiagonal]);
            secondDiagonal.add(matrix[secondRowDiagonal][firstRowDiagonal]);
            firstRowDiagonal++;
            secondRowDiagonal--;
        }
        firstDiagonal.forEach(result -> System.out.print(result + " "));
        System.out.println();
        secondDiagonal.forEach(result -> System.out.print(result + " "));
    }

    private static int[][] readMatrix(int row, Scanner scanner) {
        int[][] matrix = new int[row][];
        for (int rows = 0; rows < matrix.length; rows++) {
            matrix[rows] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
