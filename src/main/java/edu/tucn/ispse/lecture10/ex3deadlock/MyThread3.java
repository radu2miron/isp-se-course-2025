package edu.tucn.ispse.lecture10.ex3deadlock;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class MyThread3 extends Thread {
    private Object lock1;
    private Object lock2;

    public MyThread3(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + " do activity 1");

        synchronized (lock1) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }

            synchronized (lock2) {
                System.out.println(threadName + " do critical activity 2");
            }

            System.out.println(threadName + " do activity 3");
        }
    }
}
