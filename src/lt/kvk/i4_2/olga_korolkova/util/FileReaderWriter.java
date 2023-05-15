package lt.kvk.i4_2.olga_korolkova.util;



import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileReaderWriter {
    public static List<String> readLinesFromFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + filePath);
        }
        return Files.readAllLines(Path.of(filePath));
    }

    public static void writeLinesToFile(String filePath, List<String> lines) throws IOException {
        Files.write(Path.of(filePath), lines, StandardOpenOption.APPEND);
    }
}

