package edu.tucn.ispse.lecture9.ex5interruptedexception;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class SleeperThread extends Thread {
    public void run() {
        try {
            while (true) {
                System.out.println("do something");
                Thread.sleep(24 * 60 * 60 * 1000); // 24h sleep
            }
        } catch (InterruptedException e) {
            System.out.println("The sleeper thread got interrupted!");
        }
    }
}
