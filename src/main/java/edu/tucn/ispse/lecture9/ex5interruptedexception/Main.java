package edu.tucn.ispse.lecture9.ex5interruptedexception;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Main {
    public static void main(String[] args) {
        SleeperThread sleeperThread = new SleeperThread();
        sleeperThread.start();
        new InterrupterThread(sleeperThread).start();
    }
}
