package edu.tucn.ispse.lecture12.ex1singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Ex2SingletonThreadSafe {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(3);
        List<Future<FileWriterThreadSafe>> futureFWs = new ArrayList<>();
        List<FileWriterThreadSafe> fWs = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int[] it = {i};
            futureFWs.add(
                    exec.submit(() -> {
                        FileWriterThreadSafe fileWriter = FileWriterThreadSafe.getInstance();
                        fileWriter.setFileName("test" + it[0]);
                        return fileWriter;
                    }));
        }

        futureFWs.forEach(fFw -> {
            try {
                fWs.add(fFw.get());
            } catch (Exception e) {
            }
        });

        exec.shutdownNow();

        System.out.printf("fw0==fw1? %b\n", fWs.get(0) == fWs.get(1));
        System.out.printf("fw1==fw2? %b\n", fWs.get(1) == fWs.get(2));
        System.out.printf("fw0.fileName='%s'\nfw1.fileName='%s'\nfw2.fileName='%s'\n",
                fWs.get(0).getFileName(),fWs.get(1).getFileName(),fWs.get(2).getFileName());
    }
}

class FileWriterThreadSafe {
    private static volatile FileWriterThreadSafe instance;
    private String fileName;

    private FileWriterThreadSafe() {
    }

    public static synchronized FileWriterThreadSafe getInstance() {
        if (instance == null) {
            instance = new FileWriterThreadSafe();
        }

        return instance;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void writeLines(List<String> lines) {
        //todo: implement
    }
}