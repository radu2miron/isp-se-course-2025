package edu.tucn.ispse.lecture5.ex2abstactClass;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Bus extends Vehicle {
    private String company; // extra attributes can be added as in the case of regular inheritance

    @Override // override abstract method - mandatory
    public void move() {
        System.out.println("It moves on roads");
    }
}
