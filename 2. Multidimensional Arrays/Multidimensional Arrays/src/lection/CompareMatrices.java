package lection;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = createMatrix(scanner);
        int[][] secondMatrix = createMatrix(scanner);

        boolean areEqual = compareMatrices(firstMatrix, secondMatrix);

        System.out.println(areEqual ? "equal" : "not equal");

        // Direct way to compare matrices
        // System.out.println(Arrays.deepEquals(firstMatrix, secondMatrix) ? "equal" : "not equal");
    }

    private static int[][] createMatrix(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int matrix[][] = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        return matrix;
    }

    private static boolean compareMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) return false;

        int firstMatrixRows = firstMatrix.length;

        for (int row = 0; row < firstMatrixRows; row++) {
            if (firstMatrix[row].length != secondMatrix[row].length) return false;

            int firstMatrixCols = firstMatrix[row].length;

            for (int col = 0; col < firstMatrixCols; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) return false;
            }
        }

        return true;
    }
}
