package cup.plugin;

import java.io.IOException;

public class CommandAdapter {

    public void exec(String command) throws InterruptedException, IOException {
        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();
    }
}
