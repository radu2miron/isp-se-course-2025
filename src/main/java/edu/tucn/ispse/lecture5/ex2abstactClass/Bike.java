package edu.tucn.ispse.lecture5.ex2abstactClass;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Bike extends Vehicle{
    @Override // override abstract method - mandatory
    public void move() {
        System.out.println("It moves by pedaling");
    }
}
