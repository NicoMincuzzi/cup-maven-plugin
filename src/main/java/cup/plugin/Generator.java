package cup.plugin;

import cup.plugin.exception.MoreFileException;

import java.io.IOException;

public class Generator {

    private final String dir;
    private final CupFile cupFile;

    public Generator() {
        dir = System.getProperty("user.dir");
        cupFile = new CupFile();
    }

    public void cupGenerate(String cupPath) throws IOException, InterruptedException, MoreFileException {
        cupPath = dir + "/" + cupPath;
        String cupFilename = cupFile.retrieve(cupPath);

        String path = dependencyPath();

        String command = "java -jar " + path + "cup-0.10k.jar " + cupFilename;
        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();
    }

    private String dependencyPath() {
        String m2RepositoryPath = System.getenv("HOME") + "/.m2/repository";
        String javaCupPath = "/edu/princeton/cup/java-cup/10k/";
        return m2RepositoryPath + javaCupPath;
    }
}

