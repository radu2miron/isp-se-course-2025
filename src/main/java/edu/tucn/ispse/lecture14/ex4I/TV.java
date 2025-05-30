package edu.tucn.ispse.lecture14.ex4I;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class TV implements Device {
    @Override
    public void start() {
        System.out.println("The TV starts");
    }

    @Override
    public void stop() {
        System.out.println("The TV stops");
    }
}
