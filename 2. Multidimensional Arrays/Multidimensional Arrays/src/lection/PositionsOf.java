package lection;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = createMatrix(scanner);
        int numberToSearch = Integer.parseInt(scanner.nextLine());
        boolean isFound = findElement(matrix, numberToSearch);

        if (!isFound) System.out.println("not found");
    }

    private static int[][] createMatrix(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
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

    private static boolean findElement(int[][] matrix, int numberToSearch) {
        boolean isFound = false;
        int rows = matrix.length;

        for (int row = 0; row < rows; row++) {
            int cols = matrix[row].length;

            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == numberToSearch) {
                    isFound = true;
                    System.out.println(row + " " + col);
                }
            }
        }

        return isFound;
    }
}
