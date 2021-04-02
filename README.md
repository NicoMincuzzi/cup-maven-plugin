# CUP Maven Plugin
[![Java CI with Maven](https://github.com/NicoMincuzzi/cup-maven-plugin/actions/workflows/maven.yml/badge.svg)](https://github.com/NicoMincuzzi/cup-maven-plugin/actions/workflows/maven.yml)
![PyPI - Python Version](https://img.shields.io/badge/java-1.8-red) [![Version](https://img.shields.io/badge/version-v0.1.0-green)](https://github.com/NicoMincuzzi/cup-maven-plugin) ![GitHub repo size](https://img.shields.io/github/repo-size/NicoMincuzzi/cup-maven-plugin)

CUP Maven Plugin for [CUP Parser Generator](https://www.cs.princeton.edu/~appel/modern/java/CUP/). It is optimize for `CUP v0.10` and allow to generate `parser.java` and `sym.java` files by any `*.cup` file.

## Prerequisites

The run-time library version of Java CUP library must correspond to version `CUP v0.10`.

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
