# CUP Maven Plugin

[CUP](https://www.cs.princeton.edu/~appel/modern/java/CUP/)

## Prerequisites

The run-time library version of Java CUP library must correspond to version which the plug-in is using for parser generation.

In order to use it, you must add a dependency to your `pom.xml`:

``` xml
<dependency>
    <groupId>edu.princeton.cup</groupId>
    <artifactId>java-cup</artifactId>
    <version>10k</version>
</dependency>
```

## Usage
To use this plugin, you will have to tell Maven to execute the plugin at some point during the build process. To do so, add the following to the plugins-section of your pom.xml.

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
