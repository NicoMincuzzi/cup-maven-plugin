package cup.plugin;

import java.io.IOException;

public class Generator {
    public void cupGenerate(String dir, String cupPath) throws IOException, InterruptedException {
        cupPath = dir + "/" + cupPath;

        String m2Path = "/Users/nicola/.m2/repository";
        String javaCupPath = "/edu/princeton/cup/java-cup/10k/";
        String path = m2Path + javaCupPath;

        String result = "java -jar " + path + "cup-0.10k.jar " + cupPath + "/" + "Expr.cup";

        Process process = Runtime.getRuntime().exec(result);
        process.waitFor();
    }
}

