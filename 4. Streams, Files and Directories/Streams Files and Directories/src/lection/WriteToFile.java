package lection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WriteToFile {
    public static void main(String[] args) {
        String inputPath = "C:\\SoftUni\\4. Streams, Files and Directories\\Ресурси\\input.txt";
        String outputPath = "C:\\SoftUni\\4. Streams, Files and Directories\\Ресурси\\02.WriteToFileOutput.txt";

        try (
            FileInputStream in = new FileInputStream(inputPath);
            FileOutputStream out = new FileOutputStream(outputPath)
        ) {
            List<Character> symbols = new ArrayList<>();
            Collections.addAll(symbols, '.', ',', '!', '?');

            int singleByte;

            while ((singleByte = in.read()) != -1) {
                if (!symbols.contains((char) singleByte)) {
                    out.write(singleByte);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
