package cup.plugin;

import cup.plugin.exception.MoreFileException;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.IOException;


@Mojo(name = "generate", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class CupMojo extends AbstractMojo {

    @Parameter(property = "outputDirectory")
    String outputDirectory;

    @Parameter(property = "cupDefinition")
    String cupDefinition;

    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    MavenProject project;

    private final Generator generator;
    private final GeneratedFile generatedFile;

    public CupMojo() {
        generator = new Generator(new CupFile(), new CommandAdapter());
        generatedFile = new GeneratedFile();
    }

    public void execute() {
        try {
            getLog().debug("Execute Cup parser");
            String output = "/" + "src/main/java/" + outputDirectory + "/";
            generator.cupGenerate(cupDefinition);
            getLog().debug("End Cup parser");

            generatedFile.move(output, "parser.java");
            generatedFile.move(output, "sym.java");
            getLog().debug("Generated files correctly move.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MoreFileException e) {
            e.printStackTrace();
        }
    }

}
