package edu.tucn.ispse.lecture9.ex3runnable;

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

    /**
     * Implement the start() method in this class, in order to provide the same experience as in the case of {@link edu.tucn.ispse.lecture9.ex1thread.MyThread}
     */
    public void start() {
        new Thread(this).start();
    }
}
