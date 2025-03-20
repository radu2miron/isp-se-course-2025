package edu.tucn.ispse.lecture5.ex4lambdas.ex42;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Main {
    public static void main(String[] args) {
        // define the computations
        Computation addition = (a, b) -> a + b;
        Computation subtraction = (a, b) -> a - b;
        Computation multiplication = (a, b) -> a * b;
        Computation division = (a, b) -> a / b;

        // call computations and print results
        displayResultOfComputation(5.48, 6.113, addition);
        displayResultOfComputation(26.2, 3.2, subtraction);
        displayResultOfComputation(18.567, 3.21234, multiplication);
        displayResultOfComputation(16.3123, 8, division);
        displayResultOfComputation(58.2546, 1.215, (a, b) -> Math.pow(a, b) * 2);
    }

    public static void displayResultOfComputation(double a, double b, Computation computer) {
        System.out.println("Result: " + computer.compute(a, b));
    }
}
