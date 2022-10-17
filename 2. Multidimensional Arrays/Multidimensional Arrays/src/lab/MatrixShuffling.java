package lab;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] matrix = generateMatrix(scanner);
        executeCommands(scanner, matrix);
    }

    private static String[][] generateMatrix(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split(" ");
        }

        return matrix;
    }

    private static void executeCommands(Scanner scanner, String[][] matrix) {
        String input = scanner.nextLine();
        int rows = matrix.length;
        int cols = matrix[0].length;

        while (!input.equals("END")) {
            String[] elements = input.split(" ");

            if (elements.length != 5) {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }

            String command = elements[0];

            if (!command.equals("swap")) {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }

            int row1 = Integer.parseInt(elements[1]);
            int col1 = Integer.parseInt(elements[2]);
            int row2 = Integer.parseInt(elements[3]);
            int col2 = Integer.parseInt(elements[4]);

            if (row1 < 0 || row1 >= rows || col1 < 0 || col1 >= cols ||
                row2 < 0 || row2 >= rows || col2 < 0 || col2 >= cols)
            {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }

            String temp = matrix[row1][col1];
            matrix[row1][col1] = matrix[row2][col2];
            matrix[row2][col2] = temp;

            printMatrix(matrix);

            input = scanner.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String str : arr) {
                System.out.print(str + " ");
            }

            System.out.println();
        }
    }
}
