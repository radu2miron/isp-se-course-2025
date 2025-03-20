package edu.tucn.ispse.lecture5.ex4lambdas.ex43StandardFunctionalIntefaces;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Computer {
    private int yearOfManufacturing;
    private int numberOfCores;
    private String producer;
    // etc.

    public Computer(int yearOfManufacturing, int numberOfCores, String producer) {
        this.yearOfManufacturing = yearOfManufacturing;
        this.numberOfCores = numberOfCores;
        this.producer = producer;
    }

    public int getYearOfManufacturing() {
        return yearOfManufacturing;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public String getProducer() {
        return producer;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "yearOfManufacturing=" + yearOfManufacturing +
                ", numberOfCores=" + numberOfCores +
                ", producer='" + producer + '\'' +
                '}';
    }
}
