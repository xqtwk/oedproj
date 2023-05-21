package lt.kvk.i4_2.olga_korolkova.tests;

import org.junit.*;

import lt.kvk.i4_2.olga_korolkova.util.FileReaderWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class FileReaderWriterTest {
    private final String base = "D:\\pathtomainprojectfolder";
    private final String filePath = base+"src\\lt\\kvk\\i4_2\\olga_korolkova\\tests\\data\\test.txt";

    @Before
    public void setup() throws IOException {
        createTestFile(filePath);
    }

    @Test
    public void testReadLinesFromFile() throws IOException {
        List<String> lines = FileReaderWriter.readLinesFromFile(filePath);
        List<String> expectedLines = Arrays.asList("Line A", "Line B", "Line C");
        System.out.println(filePath);
        Assert.assertEquals(expectedLines, lines);
    }

    @Test
    public void testWriteLinesToFile() throws IOException {
        List<String> newLines = Arrays.asList("Line 1", "Line 2", "Line 3");
        FileReaderWriter.writeLinesToFile(filePath, newLines);

        List<String> lines = FileReaderWriter.readLinesFromFile(filePath);

        Assert.assertEquals(newLines, lines);
    }

    @Test
    public void testAppendLineToFile() throws IOException {
        String appendedLine = "Appended line";
        FileReaderWriter.appendLineToFile(filePath, appendedLine);

        List<String> lines = FileReaderWriter.readLinesFromFile(filePath);
        List<String> expectedLines = Arrays.asList("Line A", "Line B", "Line C", "Appended line");

        Assert.assertEquals(expectedLines, lines);
    }

    private void createTestFile(String filePath) throws IOException {
        List<String> lines = Arrays.asList("Line A", "Line B", "Line C");
        Path file = Path.of(filePath);
        Files.write(file, lines);
    }
}
