package edu.tucn.ispse.lecture5.ex4lambdas.ex41;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Main {
    public static void main(String[] args) {
        // MyFunctionInterface implemented as an anonymous class
        MyFunctionInterface fObj1 = new MyFunctionInterface() {
            @Override
            public void function(int x) {
                System.out.printf("%d+1=%d\n", x, (x + 1));
            }
        };
        fObj1.function(10);

        // MyFunctionInterface implemented with a lambda expression
        MyFunctionInterface fObj2 = x -> System.out.printf("%d^2=%d\n", x, (x * x));
        fObj2.function(20);
    }
}
