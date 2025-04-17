package edu.tucn.ispse.lecture9.ex2runnable;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Main {
    public static void main(String[] args) {
        MyRunnable r1 = new MyRunnable();
        MyRunnable r2 = new MyRunnable();

        new Thread(r1).start();
        new Thread(r2).start();
    }
}
