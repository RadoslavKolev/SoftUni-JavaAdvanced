import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LiveDemo {
    public static void main(String[] args) {
        try {
            openFileStream();
        } catch (IOException e) {
            System.out.println("File cannot be closed");
        }
    }

    private static void openFileStream() throws IOException {
        String path = "C:\\SoftUni\\4. Streams, Files and Directories\\Ресурси\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            // Read as input bytes
            int singleByte = fileInputStream.read();

            // The end of the file returns -1 (empty)
            while (singleByte != -1) {
                // casting the bytes to char, so we can see letters
                System.out.print((char) singleByte);
                singleByte = fileInputStream.read();
            }

            // Read from scanner
//        Scanner scanner = new Scanner(fileInputStream);
//
//        String input = scanner.nextLine();
//
//        while (scanner.hasNextLine()) {
//            System.out.println(input);
//            input = scanner.nextLine();
//        }
        } catch (FileNotFoundException e) {
            System.out.println("File not found! " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Cannot read from file");
        }
    }
}
