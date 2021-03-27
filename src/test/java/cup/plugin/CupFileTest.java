package cup.plugin;

import cup.plugin.exception.MoreFileException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CupFileTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    CupFile cupFile = new CupFile();

    @Test
    public void retrieveCupFile_NoSuchFile_Null() throws MoreFileException {
        try {
            cupFile.retrieve("dir");
            fail();
        } catch (NoSuchFileException e) {
            Assert.assertEquals("No such or directory exists.", e.getReason());
        }
    }

    @Test
    public void retrieveCupFile_NoSuchFile_Empty() throws IOException, MoreFileException {
        String absolutePath = temporaryFolder.newFolder("dir").getAbsolutePath();
        try {
            cupFile.retrieve(absolutePath);
            fail();
        } catch (NoSuchFileException e) {
            Assert.assertEquals("No such or directory exists.", e.getReason());
        }
    }

    @Test
    public void retrieveCupFile_MoreFile() throws IOException {
        File folder = temporaryFolder.newFolder("dir");
        String absolutePath = folder.getAbsolutePath();

        temporaryFolder.newFile(folder.getName() + File.separator + "file1.txt");
        temporaryFolder.newFile(folder.getName() + File.separator + "file2.txt");

        try {
            cupFile.retrieve(absolutePath);
            fail();
        } catch (MoreFileException e) {
        }
    }

    @Test
    public void retrieveCupFile_Success() throws IOException, MoreFileException {
        File folder = temporaryFolder.newFolder("dir");
        String absolutePath = folder.getAbsolutePath();

        temporaryFolder.newFile(folder.getName() + File.separator + "file.cup");

        String expected = absolutePath + File.separator + "file.cup";
        String result = cupFile.retrieve(absolutePath);
        assertEquals(expected, result);
    }

    @Test
    public void retrieveCupFile_NoCupFileExists() throws IOException, MoreFileException {
        File folder = temporaryFolder.newFolder("dir");
        String absolutePath = folder.getAbsolutePath();

        temporaryFolder.newFile(folder.getName() + File.separator + "file.txt");

        try {
            cupFile.retrieve(absolutePath);
            fail();
        } catch (NoSuchFileException e) {
            Assert.assertEquals("No *.cup file exists in current directory: " + absolutePath, e.getReason());
        }
    }
}
