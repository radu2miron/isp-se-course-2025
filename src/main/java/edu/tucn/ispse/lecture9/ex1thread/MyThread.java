package edu.tucn.ispse.lecture9.ex1thread;

/**
 * Each instance of {@link MyThread} will write 20 messages in the console in parallel with other Threads.
 *
 * @author Radu Miron
 * @version 1
 */
public class MyThread extends Thread {
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
