package edu.tucn.ispse.lecture5.ex4lambdas.ex42;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
@FunctionalInterface
public interface Computation {
    double compute(double a, double b);

    default void someFunction(){
        System.out.println("something");
    }
}
