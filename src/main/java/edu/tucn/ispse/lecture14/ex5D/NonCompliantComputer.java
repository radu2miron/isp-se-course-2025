package edu.tucn.ispse.lecture14.ex5D;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
// TODO: This is not compliant with DIP because 3 classes are tightly couple.
// TODO: Decouple through interfaces;
public class NonCompliantComputer {
    private FancyKeyboard keyboard;
    private FancyMonitor monitor;

    public NonCompliantComputer(FancyKeyboard keyboard, FancyMonitor monitor) {
        this.keyboard = keyboard;
        this.monitor = monitor;
    }
}

class MainNC {
    public static void main(String[] args) {
        NonCompliantComputer nonCompliantComputer =
                new NonCompliantComputer(new FancyKeyboard(), new FancyMonitor());
    }
}