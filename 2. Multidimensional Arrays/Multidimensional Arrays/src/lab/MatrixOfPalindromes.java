package lab;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] matrix = generateMatrix(scanner);
        printMatrix(matrix);
    }

    private static String[][] generateMatrix(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            char outside = (char) ('a' + row);

            for (int col = 0; col < cols; col++) {
                char inside = (char) (outside + col);
                matrix[row][col] = "" + outside + inside + outside;     // casting to String (or with "String.valueOf()")
            }
        }

        return matrix;
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
