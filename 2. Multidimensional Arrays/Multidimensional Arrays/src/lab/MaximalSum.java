package lab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = generateMatrix(scanner);
        printMaxMatrix(matrix);
    }

    private static int[][] generateMatrix(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        return matrix;
    }

    private static void printMaxMatrix(int[][] matrix) {
        int[][] result = findMax3X3Matrix(matrix);
        printMatrix(result);
    }

    private static int[][] findMax3X3Matrix(int[][] matrix) {
        int[][] result = new int[3][3];
        int maxSum = Integer.MIN_VALUE;
        int rows = matrix.length;

        // The last 2 rows and columns cannot create 3x3 matrix
        // That's why we don't need to iterate over them
        for (int row = 0; row < rows - 2; row++) {
            int cols = matrix[row].length;

            for (int col = 0; col < cols - 2; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                        matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if (maxSum < currentSum) {
                    maxSum = currentSum;
                    result = new int[][] {
                            {matrix[row][col], matrix[row][col + 1], matrix[row][col + 2]},
                            {matrix[row + 1][col], matrix[row + 1][col + 1], matrix[row + 1][col + 2]},
                            {matrix[row + 2][col], matrix[row + 2][col + 1], matrix[row + 2][col + 2]}
                    };
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        return result;
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
