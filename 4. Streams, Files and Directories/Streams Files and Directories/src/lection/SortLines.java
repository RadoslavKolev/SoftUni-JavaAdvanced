package lection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) {
        Path inputPath = Paths.get("C:\\SoftUni\\4. Streams, Files and Directories\\Ресурси\\input.txt");
        Path outputPath = Paths.get("C:\\SoftUni\\4. Streams, Files and Directories\\Ресурси\\06.SortLinesOutput.txt");

        try {
            List<String> lines = Files.readAllLines(inputPath);
            lines = lines.stream()
                    .filter(line -> !line.isBlank())
                    .collect(Collectors.toList());

            Collections.sort(lines);
            Files.write(outputPath, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
