package edu.tucn.ispse.lecture9.ex6decoupling;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class FileUtils {

    private FileUtils() {
    }

    public static void generateFile(String filePath) {
        long t1 = System.currentTimeMillis();

        try (FileWriter fileWriter = new FileWriter(filePath)) {
            for (int i = 0; i < 10_000_000; i++) {
                fileWriter.write("" + new Random().nextInt(Integer.MAX_VALUE));
            }

            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        long t2 = System.currentTimeMillis();
        System.out.printf("Generated file in %d sec.\n", (t2 - t1) / 1000);
    }

    public static Map<String, Integer> processFile(String path) {
        long t1 = System.currentTimeMillis();

        Map<String, Integer> results = new HashMap<>();
        try {
            Files.lines(Paths.get(path))
                    .forEach(l -> {
                        for (int i = 0; i < l.length(); i++) {
                            String key = l.charAt(i) + "";
                            Integer value = results.get(key);

                            if (value == null) {
                                value = 1;
                            } else {
                                value++;
                            }

                            results.put(key, value);
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        long t2 = System.currentTimeMillis();
        System.out.printf("Processed file in %d sec.\n", (t2 - t1) / 1000);

        return results;
    }

    public static void main(String[] args) {
        String filePath = "testfiles/" + UUID.randomUUID() + ".txt"; // generate random file name
        FileUtils.generateFile(filePath); // generate the file
        Map<String, Integer> results = FileUtils.processFile(filePath); // process the file

        System.out.println("Char frequency: " + results);
    }
}
