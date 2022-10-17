package lection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        String inputPath = "C:\\SoftUni\\4. Streams, Files and Directories\\Ресурси\\input.txt";
        String outputPath = "C:\\SoftUni\\4. Streams, Files and Directories\\Ресурси\\04.ExtractIntegersOutput.txt";

        try {
            Scanner scanner = new Scanner(new FileInputStream(inputPath));
            PrintWriter out = new PrintWriter(new FileOutputStream(outputPath));

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    out.println(scanner.nextInt());
                }

                scanner.next();
            }

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
