package cup.plugin;

import cup.plugin.exception.MoreFileException;

import java.io.IOException;

public class Generator {

    private final String dir;
    private final CupFile cupFile;
    private final CommandAdapter commandAdapter;

    public Generator(CupFile cupFile, CommandAdapter commandAdapter) {
        dir = System.getProperty("user.dir");
        this.cupFile = cupFile;
        this.commandAdapter = commandAdapter;
    }

    public void cupGenerate(String cupPath) throws IOException, InterruptedException, MoreFileException {
        cupPath = dir + "/" + cupPath;
        String cupFilename = cupFile.retrieve(cupPath);

        String path = dependencyPath();

        String command = "java -jar " + path + "cup-0.10k.jar " + cupFilename;
        commandAdapter.exec(command);
    }

    private String dependencyPath() {
        String m2RepositoryPath = System.getenv("HOME") + "/.m2/repository";
        String javaCupPath = "/edu/princeton/cup/java-cup/10k/";
        return m2RepositoryPath + javaCupPath;
    }
}

