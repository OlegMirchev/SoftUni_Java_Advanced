package JavaAdvanced2021.JavaAdvanced.MultidimensionalArraysLAB1709;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine());
        int col = Integer.parseInt(scanner.nextLine());
        char[][] firstMatrix = readMatrix(row, col, scanner);
        char[][] secondMatrix = readMatrix(row, col, scanner);
        char[][] threeMatrixIntersectionResult = getMatricesIntersection(firstMatrix, secondMatrix);

        printMatrixResult(threeMatrixIntersectionResult);
    }

    private static char[][] readMatrix(int row, int col, Scanner scanner) {
        char[][] matrix = new char[row][col];
        for (int rows = 0; rows < row; rows++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int cols = 0; cols < input.length; cols++) {
                matrix[rows][cols] = input[cols].charAt(0);
            }
        }
        return matrix;
    }

    private static char[][] getMatricesIntersection(char[][] firstMatrix, char[][] secondMatrix) {
        char[][] matrix = new char[firstMatrix.length][];
        for (int row = 0; row < firstMatrix.length; row++) {
            matrix[row] = new char[firstMatrix[row].length];
            for (int col = 0; col < firstMatrix[row].length; col++) {
                matrix[row][col] = firstMatrix[row][col] == secondMatrix[row][col]
                        ? firstMatrix[row][col] : '*';
            }
        }
        return matrix;
    }

    private static void printMatrixResult(char[][] threeMatrixIntersectionResult) {
        for (int row = 0; row < threeMatrixIntersectionResult.length; row++) {
            for (int col = 0; col < threeMatrixIntersectionResult[row].length; col++) {
                System.out.print(threeMatrixIntersectionResult[row][col] + " ");
            }
            System.out.println();
        }
    }
}
