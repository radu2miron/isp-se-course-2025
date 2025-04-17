package edu.tucn.ispse.lecture9.ex5interruptedexception;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class InterrupterThread extends Thread {
    private SleeperThread sleeperThread;

    public InterrupterThread(SleeperThread sleeperThread) {
        this.sleeperThread = sleeperThread;
    }

    @Override
    public void run() {
        System.err.println("I'll wait 5 sec then I'll interrupt the other thread");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        sleeperThread.interrupt();
    }
}
