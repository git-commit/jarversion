package net.xerael.jarversion;

import java.io.IOException;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

/**
 * Simple tool that reads the Implementation-Version attribute of a jar file.
 */
public class JarVersion {

    public static void main(String[] args) {
        if (args.length == 1) {
            try {
                JarFile jarFile = new JarFile(args[0]);
                System.out.println(getImplementationVersionFromJarFile(jarFile));
            } catch (IOException e) {
                printFileError();
            }
        } else {
            printHelp();
        }

    }

    private static void printFileError() {
        System.out.println("There was an error reading the file.");
    }

    private static void printHelp() {
        System.out.println("This program takes exactly one argument that must" +
                " be the path to a jar file.\n" +
                "Usage example: java -jar JarVersion ATLauncher.jar");
    }

    static String getImplementationVersionFromJarFile(final JarFile jarFile) throws IOException {
        Manifest manifest = jarFile.getManifest();
        Attributes attributes = manifest.getMainAttributes();
        return attributes.getValue("Implementation-Version");
    }



    /**
     * Forbid instantiation.
     */
    private JarVersion(){}
}
