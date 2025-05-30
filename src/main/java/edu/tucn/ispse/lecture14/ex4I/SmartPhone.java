package edu.tucn.ispse.lecture14.ex4I;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class SmartPhone implements Device, Chargeable {
    @Override
    public void charge() {
        System.out.println("The smart phone charges");
    }

    @Override
    public void start() {
        System.out.println("The smart phone starts");
    }

    @Override
    public void stop() {
        System.out.println("The smart phone stops");
    }
}
