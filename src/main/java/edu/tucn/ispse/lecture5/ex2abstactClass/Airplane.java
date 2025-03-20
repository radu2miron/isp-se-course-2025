package edu.tucn.ispse.lecture5.ex2abstactClass;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Airplane extends Vehicle {
    @Override // override abstract method - mandatory
    public void move() {
        System.out.println("It flies");
    }

    @Override // override non-abstract method - not mandatory
    public void printVehicleType() {
        System.out.println("It is an " + this.getClass().getSimpleName());
    }
}
