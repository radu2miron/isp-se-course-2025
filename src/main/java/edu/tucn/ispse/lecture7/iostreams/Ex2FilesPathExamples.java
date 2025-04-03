package edu.tucn.ispse.lecture7.iostreams;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

/**
 * @author radumiron
 * @version 1
 */
public class Ex2FilesPathExamples {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("testfiles/newfile.txt");

        // write with a FileWriter
        try (FileWriter fileWriter = new FileWriter(filePath.toFile(), true)) {
            fileWriter.write("line 1\n");
            fileWriter.write("line 3\n");
        }

        // write with the Files (utilitarian class)
        Files.write(filePath, "line 3\n".getBytes(), StandardOpenOption.APPEND);

        // read all lines at ones
        List<String> lines = Files.readAllLines(filePath);
        System.out.println(lines.size());

        // let's continue writing to the file
        Files.write(filePath, "line 4\n".getBytes());

        // read lines one at a time - this does lazy reads; it can help you avoid out of memory exceptions
        System.out.println("File's lines:");
        Files.lines(filePath)
                .map(l -> l.toUpperCase())
                .forEach(l -> System.out.println(l));

        System.out.println("wait a minute... only one line?!?");
        System.out.println("That is because 'line 4' is written without the APPEND option");

        // create dir structure
        Files.createDirectories(Path.of("/tmp/abc/xyz"));

        // delete a file
        Files.delete(Path.of("/tmp/abc/xyz"));

        // copy file
        Files.copy(Path.of("pom.xml"), // source
                Path.of("/tmp/abc/pom-copy.xml"), // destination
                StandardCopyOption.REPLACE_EXISTING); // overwrite
    }
}
