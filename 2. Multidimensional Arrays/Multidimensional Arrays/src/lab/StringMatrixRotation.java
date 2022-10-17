package lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    private static Scanner scanner;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // reading the input
        String rotationInput = scanner.nextLine();
        String input = scanner.nextLine();

        int maxColumnLength = Integer.MIN_VALUE;
        List<String> wordList = new ArrayList<>();

        while (!input.equals("END")) {
            int currentLength = input.length();

            if (currentLength > maxColumnLength) {
                maxColumnLength = currentLength;
            }

            wordList.add(input);

            input = scanner.nextLine();
        }

        // creating the matrix
        int rows = wordList.size();
        int cols = maxColumnLength;
        char[][] matrix = new char[rows][cols];

        // filling the matrix
        for (int row = 0; row < rows; row++) {
            String currentWord = wordList.get(row);
            int currentLength = currentWord.length();

            for (int col = 0; col < cols; col++) {
                if (col < currentLength) {
                    char currentChar = currentWord.charAt(col);
                    matrix[row][col] = currentChar;
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }

        // rotate and print the matrix
        String angleString = rotationInput.split("[()]")[1];
        int angle = Integer.parseInt(angleString) % 360;

        printMatrix(matrix, rows, cols, angle);
    }

    private static void printMatrix(char[][] matrix, int rows, int cols, int angle) {
        switch (angle) {
            case 0:
                // don't rotate
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        System.out.print(matrix[row][col]);
                    }

                    System.out.println();
                }

                break;
            case 90:
                // rotate to the right
                for (int col = 0; col < cols; col++) {
                    for (int row = rows - 1; row >= 0 ; row--) {
                        System.out.print(matrix[row][col]);
                    }

                    System.out.println();
                }

                break;
            case 180:
                // rotate upside down
                for (int row = rows - 1; row >= 0 ; row--) {
                    for (int col = cols - 1; col >= 0 ; col--) {
                        System.out.print(matrix[row][col]);
                    }

                    System.out.println();
                }

                break;
            case 270:
                // rotate to the left

                for (int col = cols - 1; col >= 0; col--) {
                    for (int row = 0; row < rows ; row++) {
                        System.out.print(matrix[row][col]);
                    }

                    System.out.println();
                }
                break;
        }
    }
}
