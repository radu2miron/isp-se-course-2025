package edu.tucn.ispse.lecture10.ex1sync;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Main {
    public static void main(String[] args) {
        Object lock = new Object();
        new MyThread(lock).start();
        new MyThread(lock).start();
    }
}
