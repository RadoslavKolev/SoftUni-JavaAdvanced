package lection;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        String path = "C:\\SoftUni\\4. Streams, Files and Directories\\Ресурси\\input.txt";
        readFromFile(path);
    }

    private static void readFromFile(String path) {
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            int singleByte = fileInputStream.read();

            while (singleByte != -1) {
                System.out.printf("%s ", Integer.toBinaryString(singleByte));
                singleByte = fileInputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
