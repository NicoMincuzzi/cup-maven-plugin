# CUP Maven Plugin


https://www.cs.princeton.edu/~appel/modern/java/CUP/

## Prerequisites

In order to use it, you must add a dependency to your pom.xml:

``` xml
        <dependency>
            <groupId>edu.princeton.cup</groupId>
            <artifactId>java-cup</artifactId>
            <version>10k</version>
        </dependency>
```
## Usage

``` xml
<plugin>
                <groupId>com.nmincuzzi</groupId>
                <artifactId>cup-maven-plugin</artifactId>
                <version>0.1.0</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>generate</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
                    <outputDirectory>com/lefc/jambly</outputDirectory>
                    <cupDefinition>src/main/cup</cupDefinition>
                </configuration>
</plugin>
```
