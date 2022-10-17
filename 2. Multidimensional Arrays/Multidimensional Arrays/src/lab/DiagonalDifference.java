package lab;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = generateMatrix(scanner);

        int difference = calculateDifference(matrix);
        System.out.println(difference);
    }

    private static int[][] generateMatrix(Scanner scanner) {
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        return matrix;
    }

    private static int calculateDifference(int[][] matrix) {
        int sumLeft = sumPrimaryDiagonal(matrix);
        int sumRight = sumSecondaryDiagonal(matrix);

        return Math.abs(sumLeft - sumRight);
    }

    private static int sumPrimaryDiagonal(int[][] matrix) {
        int sum = 0;
        int size = matrix.length;

        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }

        return sum;
    }

    private static int sumSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        int size = matrix.length;

        for (int row = 0, col = size - 1; row < size; row++, col--) {
            sum += matrix[row][col];
        }

        return sum;
    }
}
