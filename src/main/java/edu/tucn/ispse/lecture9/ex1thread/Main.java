package edu.tucn.ispse.lecture9.ex1thread;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Main {
    public static void main(String[] args) {
        MyThread t0 = new MyThread();
        MyThread t1 = new MyThread();

// Do not start your threads like this!
//        t0.run();
//        t1.run();

// Start your threads like this!
        t0.start();
        t1.start();
    }
}
