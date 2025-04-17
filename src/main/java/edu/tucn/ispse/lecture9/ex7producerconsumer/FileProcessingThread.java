package edu.tucn.ispse.lecture9.ex7producerconsumer;

import javax.swing.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class FileProcessingThread extends Thread {
    private final JTextArea logArea;
    private ArrayBlockingQueue<File> queue;
    private static final String TXT_DIR = "testfiles";

    public FileProcessingThread(ArrayBlockingQueue<File> queue, String name, JTextArea logArea) {
        this.queue = queue;
        this.setName(name);
        this.logArea = logArea;
    }

    @Override
    public void run() {
        while (true) {
            try {
                File pdfFile = queue.take(); // get file from queue

                long t1 = System.currentTimeMillis();
                String txt = PdfUtils.getText(pdfFile); // extract text from pdf
                Path txtPath = Paths.get(TXT_DIR, pdfFile.getName().replace(".pdf", ".txt"));
                Files.writeString(txtPath, txt); // write to text file
                long t2 = System.currentTimeMillis();

                logArea.append(String.format("Thread %s extracted text to %s in %d ms %s",
                        Thread.currentThread().getName(),
                        txtPath.toFile().getName(),
                        t2-t1,
                        "\n"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
