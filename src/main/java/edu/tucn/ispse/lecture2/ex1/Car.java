package edu.tucn.ispse.lecture2.ex1;

import java.util.Objects;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */

public class Car {
    public static final int NUMBER_OF_WHEELS = 4;
    private static int counter;
    private String brand;
    private String model;
    private String color;
    private String vin;

    public Car(String brand, String model, String color, String vin) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.vin = vin;
        counter++;
    }

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;

    }

    public void start() {
        System.out.println(this.toString() + " started!");
    }

    public void travel() {
        System.out.println(this + " is traveling!");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(this.vin, car.vin);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public static int getCounter() {
        return counter;
    }
}
