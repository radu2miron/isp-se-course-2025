package edu.tucn.ispse.lecture14.ex3L;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class TV implements Device {
    @Override
    public void charge() {
        // TODO: this is not compliant with LSP because this method is not implemented and it will break the application.
        // TODO: Obviously the TV doesn't need to be charged. To fix this, use ISP.
        // TODO: see ex4I that follows both LSP and ISP.
        throw new RuntimeException("The TV doesn't need to be charged. It's always plugged in.");
    }

    @Override
    public void start() {
        System.out.println("TV starts");
    }

    @Override
    public void stop() {
        System.out.println("TV stops");
    }
}
