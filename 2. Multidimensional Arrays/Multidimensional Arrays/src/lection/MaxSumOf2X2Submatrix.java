package lection;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSumOf2X2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = createMatrix(scanner);
        printMaxMatrix(matrix);
    }

    private static int[][] createMatrix(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        return matrix;
    }

    private static void printMaxMatrix(int[][] matrix) {
        int[][] result = new int[2][2];
        int maxSum = Integer.MIN_VALUE;
        int rows = matrix.length;

        // The last column and the last row cannot form new 2x2 matrix
        // That's why we don't need to iterate over them
        for (int row = 0; row < rows - 1; row++) {
            int cols = matrix[row].length;

            for (int col = 0; col < cols - 1; col++) {
                int currentSum = matrix[row][col] +
                        matrix[row][col + 1] +
                        matrix[row + 1][col] +
                        matrix[row + 1][col + 1];

                if (maxSum < currentSum) {
                    maxSum = currentSum;
                    result = new int[][] {
                            {matrix[row][col], matrix[row][col + 1]},
                            {matrix[row + 1][col], matrix[row + 1][col + 1]}
                    };
                }
            }
        }

        printMatrix(result);

        System.out.println(maxSum);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int num : arr) {
                System.out.print(num + " ");
            }

            System.out.println();
        }
    }
}
