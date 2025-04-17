package edu.tucn.ispse.lecture9.ex4lambda;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Main {
    public static void main(String[] args) {
        Runnable runnable = () -> printMessages();
        new Thread(runnable).start(); // new thread
        new Thread(() -> printMessages()).start(); // new thread
        new Thread(Main::printMessages).start(); // new thread
    }

    /**
     * Prints 20 messages in the console
     */
    public static void printMessages() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + " - message " + i);

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
            }
        }
    }
}
