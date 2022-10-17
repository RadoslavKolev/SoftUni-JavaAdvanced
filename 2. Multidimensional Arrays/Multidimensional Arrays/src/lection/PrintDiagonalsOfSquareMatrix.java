package lection;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = createMatrix(scanner);

        printDiagonals(matrix);
    }

    private static int[][] createMatrix(Scanner scanner) {
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        return matrix;
    }

    private static void printDiagonals(int[][] matrix) {
        String leftDiagonal = "";
        String rightDiagonal = "";
        int size = matrix.length;

        // Cycle for the left diagonal
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (row == col) {
                    leftDiagonal += matrix[row][col] + " ";
                }
            }
        }

        // Cycle for the right diagonal (from bottom)
        int row = size - 1;
        int col = 0;

        while (isInBounds(row, col, matrix)) {
            rightDiagonal += matrix[row][col] + " ";
            row--;
            col++;
        }

        System.out.println(leftDiagonal);
        System.out.println(rightDiagonal);
    }

    // Works not only for square matrices
    private static boolean isInBounds(int row, int col, int[][] matrix) {
        return (row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length);
    }

//    private static boolean isOutOfBounds(int row, int col, int[][] matrix) {
//        return !isInBounds(row, col, matrix);
//    }
}
