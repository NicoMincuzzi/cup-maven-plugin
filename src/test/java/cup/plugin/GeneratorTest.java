package cup.plugin;

import cup.plugin.exception.MoreFileException;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class GeneratorTest {

    @Test
    public void cupGenerate_Success() throws InterruptedException, MoreFileException, IOException {
        CommandAdapter commandAdapter = mock(CommandAdapter.class);
        CupFile cupFile = mock(CupFile.class);

        when(cupFile.retrieve("/Users/nicola/Nicola/projects/github/cup-maven-plugin/cupPath")).thenReturn("cupFilename");

        Generator generator = new Generator(cupFile, commandAdapter);
        generator.cupGenerate("cupPath");

        ArgumentCaptor<String> command = ArgumentCaptor.forClass(String.class);
        verify(commandAdapter, times(1)).exec(command.capture());
        List<String> capturedPeople = command.getAllValues();
        assertEquals("java -jar /Users/nicola/.m2/repository/edu/princeton/cup/java-cup/10k/cup-0.10k.jar cupFilename", capturedPeople.get(0));
    }
}
