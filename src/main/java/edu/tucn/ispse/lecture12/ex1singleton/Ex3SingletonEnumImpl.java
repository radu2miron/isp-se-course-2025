package edu.tucn.ispse.lecture12.ex1singleton;

import java.util.List;

/**
 * This implementation is thread-safe
 *
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public enum Ex3SingletonEnumImpl {
    INSTANCE;

    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void writeLines(List<String> lines) {
        //todo: implement
    }

    public static void main(String[] args) {
        Ex3SingletonEnumImpl fileWriter1 = Ex3SingletonEnumImpl.INSTANCE;
        fileWriter1.setFileName("test1");

        System.out.println("After the first call of getInstance()");
        System.out.println(fileWriter1.getFileName());

        Ex3SingletonEnumImpl fileWriter2 = Ex3SingletonEnumImpl.INSTANCE;
        fileWriter2.setFileName("test2");

        System.out.println("After the second call of getInstance()");
        System.out.println("fileWriter1.fileName: " + fileWriter1.getFileName());
        System.out.println("fileWriter2.fileName: " + fileWriter2.getFileName());

        System.out.println("fileWriter1 == fileWriter2? " + (fileWriter1 == fileWriter2));
    }
}
