import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {
    public static void createFile(Path directory, String fileName) throws IOException {
        Path filePath = directory.resolve(fileName);
        Files.createFile(filePath);
    }
}
