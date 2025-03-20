package edu.tucn.ispse.lecture5.ex2abstactClass;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public abstract class Vehicle {
    private int wheelsNum;
    private String manufacturer;

    public abstract void move();

    public void printVehicleType(){
        System.out.println("It is a " + this.getClass().getSimpleName());
    }
}
