package cup.plugin;

import java.io.IOException;

public class Generator {

    private final String dir;

    public Generator() {
        dir = System.getProperty("user.dir");
    }

    public void cupGenerate(String cupPath) throws IOException, InterruptedException {
        cupPath = dir + "/" + cupPath;

        String path = dependencyPath();

        //TODO Retrieve .cup file and verify that is unique
        String cupFile = "Expr.cup";

        String command = "java -jar " + path + "cup-0.10k.jar " + cupPath + "/" + cupFile;

        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();
    }

    private String dependencyPath() {
        String m2RepositoryPath = "$HOME/.m2/repository";
        String javaCupPath = "/edu/princeton/cup/java-cup/10k/";
        return m2RepositoryPath + javaCupPath;
    }
}

