package lab;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");

        int size = Integer.parseInt(input[0]);
        char pattern = input[1].charAt(0);
        int[][] matrix = generateMatrix(size, pattern);

        printMatrix(matrix);
    }

    private static int[][] generateMatrix(int size, char pattern) {
        int[][] matrix = new int[size][size];

        if (pattern == 'A') {
            matrix = generateA(matrix);
        } else if (pattern == 'B') {
            matrix = generateB(matrix);
        }

        return matrix;
    }

    private static int[][] generateA(int[][] matrix) {
        int counter = 1;
        int size = matrix.length;

        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = counter;
                counter++;
            }
        }

        return matrix;
    }

    private static int[][] generateB(int[][] matrix) {
        int counter = 1;
        boolean fromTop = true; // or check if the column is even (col % 2 == 0)
        int size = matrix.length;

        for (int col = 0; col < size; col++) {
            if (fromTop) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = counter;
                    counter++;
                }
            } else {
                for (int row = size - 1; row >= 0; row--) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }

            fromTop = !fromTop;
        }

        return matrix;
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
