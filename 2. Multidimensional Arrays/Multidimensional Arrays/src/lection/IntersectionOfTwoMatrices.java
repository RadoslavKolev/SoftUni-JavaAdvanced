package lection;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = createMatrix(scanner, rows, cols);
        char[][] secondMatrix = createMatrix(scanner, rows, cols);
        char[][] output = outputMatrix(firstMatrix, secondMatrix, rows, cols);

        printMatrix(output);
    }

    private static char[][] createMatrix(Scanner scanner, int rows, int cols) {
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine()
                    .replaceAll("\\s+", "")
                    .toCharArray();
        }

        return matrix;
    }

    private static char[][] outputMatrix(char[][] first, char[][] second, int rows, int cols) {
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char firstElem = first[row][col];
                char secondElem = second[row][col];
                char fillChar = (firstElem == secondElem) ? firstElem : '*';
                matrix[row][col] = fillChar;
            }
        }

        return matrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char ch : chars) {
                System.out.print(ch + " ");
            }

            System.out.println();
        }
    }

//    private static void printMatrix(char[][] matrix) {
//        int rows = matrix.length;
//
//        for (int row = 0; row < rows; row++) {
//            int cols = matrix[row].length;
//
//            for (int col = 0; col < cols; col++) {
//                System.out.print(matrix[row][col] + " ");
//            }
//
//            System.out.println();
//        }
//    }
}
