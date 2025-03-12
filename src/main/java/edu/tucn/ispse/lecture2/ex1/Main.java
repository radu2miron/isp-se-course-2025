package edu.tucn.ispse.lecture2.ex1;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("BMW", "M5", "black", "123");
        Car car2 = new Car("Mercedes", "CLS", "grey", "222");
        Car car3 = new Car("Dacia", "Logan", "white", "678");
        Car car4 = car1; // assignment by reference
        Car car5 = new Car("BMW", "M5", "red", "123");


        car2 = null; // dereferenced object

        car1.start(); // instance method call
        car1.travel();

        System.out.printf("is %s the same as %s? %b\n", car1, car5, car1.equals(car5));

        int cars = Car.getCounter(); // static method call
        System.out.printf("There are %d cars\n", cars);
    }
}