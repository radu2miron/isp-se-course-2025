package edu.tucn.ispse.lecture9.ex2runnable;

/**
 * Each instance of {@link MyRunnable} will write 20 messages in the console in parallel with other threads.
 *
 * @author Radu Miron
 * @version 1
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + " - message " + i);

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
            }
        }
    }
}
