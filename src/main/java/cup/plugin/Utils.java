package cup.plugin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {

    public static void moveGeneratedFile(String target, String filename) throws IOException {
        Path fileToMovePath = Paths.get(filename);
        Path targetPath = Paths.get(target + filename);
        Files.move(fileToMovePath, targetPath);
    }
}
