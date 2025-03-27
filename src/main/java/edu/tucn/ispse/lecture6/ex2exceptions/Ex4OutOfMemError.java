package edu.tucn.ispse.lecture6.ex2exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
// todo run this without and with option: -Xmx5M

public class Ex4OutOfMemError {
    public static void main(String[] args) {
        Path path = Paths.get("/home/radu/backups/_to_save/books/hyperledger-fabric.pdf"); // file bigger than 5MB

        try {
            byte[] bytes = Files.readAllBytes(path);
            System.out.println(bytes.length + "B");
            System.out.println(Files.size(path) / 1024 / 1024 + "MB");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
