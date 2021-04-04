package cup.plugin;

import cup.plugin.exception.MoreFileException;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class GeneratorTest {

    @Test
    public void cupGenerate_Success() throws InterruptedException, MoreFileException, IOException {
        CommandAdapter commandAdapter = mock(CommandAdapter.class);
        CupFile cupFile = mock(CupFile.class);
        String dir = System.getProperty("user.dir");

        when(cupFile.retrieve(dir + "/" + "cupPath")).thenReturn("cupFilename");

        Generator generator = new Generator(cupFile, commandAdapter);
        generator.cupGenerate("cupPath");

        ArgumentCaptor<String> command = ArgumentCaptor.forClass(String.class);
        verify(commandAdapter, times(1)).exec(command.capture());
        String result = command.getAllValues().get(0);
        String expected = "java -jar " + System.getenv("HOME") + "/.m2/repository/edu/princeton/cup/java-cup/10k/cup-0.10k.jar cupFilename";
        assertEquals(expected, result);
    }
}
