package lection;

import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) {
        String inputPath = "C:\\SoftUni\\4. Streams, Files and Directories\\Ресурси\\input.txt";
        String outputPath = "C:\\SoftUni\\4. Streams, Files and Directories\\Ресурси\\05.WriteEveryThirdLineOutput.txt";

        try (
                BufferedReader in = new BufferedReader(new FileReader(inputPath));
                PrintWriter out = new PrintWriter(new FileWriter(outputPath));
        ) {
            int counter = 1;
            String line;

            while ((line = in.readLine()) != null) {
                if (counter % 3 == 0) {
                    out.println(line);
                }

                counter++;
            }
        } catch (IOException e) {
            System.err.println("File problem");
            e.printStackTrace();
        }
    }
}
