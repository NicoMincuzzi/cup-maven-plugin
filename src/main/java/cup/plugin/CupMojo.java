package cup.plugin;

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

    private final String dir;

    private final Generator generator;

    public CupMojo() {
        generator = new Generator();
        dir = System.getProperty("user.dir");
    }

    public void execute() {

        try {
            getLog().debug("Execute Cup parser");
            String output = dir + "/" + "src/main/java/" + outputDirectory + "/";
            generator.cupGenerate(dir, cupDefinition);

            Utils.moveGeneratedFile(output, "parser.java");
            Utils.moveGeneratedFile(output, "sym.java");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
