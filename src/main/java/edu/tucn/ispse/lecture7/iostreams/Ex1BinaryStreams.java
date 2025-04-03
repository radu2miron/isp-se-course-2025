package edu.tucn.ispse.lecture7.iostreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author radumiron
 * @version 1
 */
public class Ex1BinaryStreams {
    public static void main(String[] args) {
        String sourceFilePath = "testfiles/test.png";
        String destinationFilePath = "testfiles/test-copy.png";

        try (FileInputStream in = new FileInputStream(sourceFilePath);
             FileOutputStream out = new FileOutputStream(destinationFilePath)) {
            int c;
            while ((c = in.read()) != -1) { // ‘c’ is the int value of a byte
                out.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println();
        }
    }
}
