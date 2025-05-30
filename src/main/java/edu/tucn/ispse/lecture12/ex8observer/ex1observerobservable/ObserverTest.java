package edu.tucn.ispse.lecture12.ex8observer.ex1observerobservable;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */

class Alarm extends Observable {
    boolean ring;

    public void startStop() {
        // change observable state
        this.ring = !this.ring;

        // notify state change to observer(s)
        this.setChanged();
        this.notifyObservers(ring);
    }
}

class TextMonitor implements Observer {

    @Override
    public void update(Observable o, Object arg) { // triggered by observable state change
        if ((Boolean) arg) {
            System.out.println("Brrrr!!!!!");
        }
    }
}

class UiMonitor extends JFrame implements Observer {
    public UiMonitor() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 300);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        if ((Boolean) arg) {
            JLabel label = new JLabel("Brrrr!!!!!");
            label.setBounds(new Random().nextInt(250) + 10, new Random().nextInt(250) + 10, 100, 20);
            this.add(label);
            this.repaint();
        }
    }
}

public class ObserverTest {
    public static void main(String[] args) throws InterruptedException {
        Alarm alarm = new Alarm(); // observable
        TextMonitor textMonitor = new TextMonitor(); // observer 1
        UiMonitor uiMonitor = new UiMonitor(); // observer 2

        alarm.addObserver(textMonitor); // link observable to observer 1
        alarm.addObserver(uiMonitor); // link observable to observer 2

        while (true) {
            Thread.sleep(1000);
            alarm.startStop(); // trigger observable state change
        }
    }
}
