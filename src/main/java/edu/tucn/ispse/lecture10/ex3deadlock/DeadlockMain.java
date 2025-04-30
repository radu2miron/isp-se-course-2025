package edu.tucn.ispse.lecture10.ex3deadlock;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class DeadlockMain {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        new MyThread3(lock1, lock2).start();
        new MyThread3(lock2, lock1).start();
    }
}
