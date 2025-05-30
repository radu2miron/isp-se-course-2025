package edu.tucn.ispse.lecture12.ex1singleton;

import java.util.List;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Ex1Singleton {
    public static void main(String[] args) {
        FileWriter fileWriter1 = FileWriter.getInstance();
        fileWriter1.setFileName("test1");

        System.out.println("After the first call of getInstance()");
        System.out.println(fileWriter1.getFileName());

        FileWriter fileWriter2 = FileWriter.getInstance();
        fileWriter2.setFileName("test2");

        System.out.println("After the second call of getInstance()");
        System.out.println("fileWriter1.fileName: " + fileWriter1.getFileName());
        System.out.println("fileWriter2.fileName: " + fileWriter2.getFileName());

        System.out.println("fileWriter1 == fileWriter2? " + (fileWriter1 == fileWriter2));
    }
}

class FileWriter {
    private static FileWriter instance;
    private String fileName;

    private FileWriter() {
    }

    public static FileWriter getInstance() {
        if (instance == null) {
            instance = new FileWriter();
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