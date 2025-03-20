package edu.tucn.ispse.lecture5.ex2abstactClass;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
                new Bike(),
                new Bus(),
                new Airplane()
        };

        for (Vehicle vehicle : vehicles) {
            vehicle.printVehicleType();
            vehicle.move();
            System.out.println();
        }
    }
}
