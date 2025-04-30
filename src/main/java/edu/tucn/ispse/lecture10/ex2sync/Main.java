package edu.tucn.ispse.lecture10.ex2sync;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Main {
    public static void main(String[] args) {
        new MyThread2().start();
        new MyThread2().start();
    }
}
