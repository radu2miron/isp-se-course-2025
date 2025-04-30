package edu.tucn.ispse.lecture10.ex4waitnotify;

import java.io.IOException;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */

public class Main {
    static final Object MONITOR = new Object();

    public static void main(String[] args) throws IOException {
        new NotifierThread().start();
        new WaiterThread().start();
    }
}