package cup.plugin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GeneratedFile {

    private final String projectCurrentDirectory;

    public GeneratedFile() {
        projectCurrentDirectory = System.getProperty("user.dir");
    }

    public void move(String target, String filename) throws IOException {
        Path fileToMovePath = Paths.get(filename);
        Path targetPath = Paths.get(projectCurrentDirectory + target + filename);
        Files.move(fileToMovePath, targetPath);
    }
}
