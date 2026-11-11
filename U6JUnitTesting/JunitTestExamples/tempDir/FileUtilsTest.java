import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileUtilsTest {

    @TempDir
    Path tempDir; // Temporary directory created before each test

    @Test
    void testCreateFile() throws IOException {
        // Arrange
        String fileName = "testFile.txt";

        // Act
        FileUtils.createFile(tempDir, fileName);

        // Assert
        Path createdFilePath = tempDir.resolve(fileName);
        assertTrue(Files.exists(createdFilePath), "The file should exist in the temporary directory");
    }
}
