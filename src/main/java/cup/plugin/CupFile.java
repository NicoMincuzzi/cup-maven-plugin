package cup.plugin;

import cup.plugin.exception.MoreFileException;

import java.io.File;
import java.nio.file.NoSuchFileException;

public class CupFile {

    public static final int MAX_NUM_CUP_FILE = 1;

    public String retrieve(String dir) throws NoSuchFileException, MoreFileException {
        File[] listFiles = new File(dir).listFiles();
        if (listFiles == null || listFiles.length == 0) {
            throw new NoSuchFileException(dir, null, "No such or directory exists.");
        }
        if (listFiles.length > MAX_NUM_CUP_FILE) {
            throw new MoreFileException();
        }
        for (File file : listFiles) {
            if (file.isDirectory()) {
                retrieve(file.getName());
            } else if (isaCupFile(file)) {
                return dir + File.separator + file.getName();
            }
        }
        String wrongFile = listFiles[0].getName();
        throw new NoSuchFileException("*.cup", wrongFile, "No *.cup file exists in current directory: " + dir);
    }

    private boolean isaCupFile(File file) {
        return file.getName().endsWith(".cup");
    }
}
