package edu.tucn.ispse.lecture10.ex5join;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Thread2 extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        System.out.println("Thread 2: I'm done");
    }
}
