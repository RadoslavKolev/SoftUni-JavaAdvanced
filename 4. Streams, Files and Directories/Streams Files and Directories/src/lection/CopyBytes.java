package lection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) {
        String inputPath = "C:\\SoftUni\\4. Streams, Files and Directories\\Ресурси\\input.txt";
        String outputPath = "C:\\SoftUni\\4. Streams, Files and Directories\\Ресурси\\03.CopyBytesOutput.txt";

        try (
            FileInputStream in = new FileInputStream(inputPath);
            FileOutputStream out = new FileOutputStream(outputPath)
        ) {
           int singleByte;

           while ((singleByte = in.read()) != -1) {
               if (singleByte == 10 || singleByte == 32) {
                   out.write(singleByte);
               } else {
                   String digits = String.valueOf(singleByte);

                   for (char ch : digits.toCharArray()) {
                       out.write(ch);
                   }
               }
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
