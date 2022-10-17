package lection;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = createMatrix(scanner);

        int sum = sumMatrix(matrix);
        System.out.println(sum);
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

        System.out.println(rows);
        System.out.println(cols);

        return matrix;
    }

    private static int sumMatrix(int[][] matrix) {
        int sum = 0;

        for (int[] arr : matrix) {
            for (int num : arr) {
                sum += num;
            }
        }

        return sum;
    }
}
