package edu.tucn.ispse.lecture12.ex8observer.ex2propertychangelistener;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */

class Alarm { // this is the observable
    private PropertyChangeSupport propertyChangeSupport;
    private boolean ring;

    public Alarm() {
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void addObserver(PropertyChangeListener observer) {
        this.propertyChangeSupport.addPropertyChangeListener(observer); // link observer
    }

    public void startStop() {
        propertyChangeSupport.firePropertyChange("change", this.ring, !this.ring); // notify observer(s) of state change
        this.ring = !this.ring;
    }
}

class TextMonitor implements PropertyChangeListener { // this is one observer

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) { // triggered by observable change notification
        if ((Boolean) propertyChangeEvent.getNewValue()) {
            System.out.println("Brrrr!!!!!");
        }
    }
}

class UiMonitor extends JFrame implements PropertyChangeListener { // this is a second observer
    public UiMonitor() throws HeadlessException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 300);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) { // triggered by observable change notification
        if ((Boolean) propertyChangeEvent.getNewValue()) {
            JLabel label = new JLabel("Brrrr!!!!!");
            label.setBounds(new Random().nextInt(250) + 10, new Random().nextInt(250) + 10, 100, 20);
            this.add(label);
            this.repaint();
        }
    }
}

public class ObserverTestPropertyChangeSupport {
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
