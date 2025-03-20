package edu.tucn.ispse.lecture5.ex3anonymous.ex30;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Main {
    public static void main(String[] args) {
        // abstract classes can't be instantiated?
        // then, what is this?
        Bicycle bicycle = new Bicycle() {
            public void move() {
                System.out.println("It moves anonymously");
            }

            @Override
            public void changeSpeed() {
                System.out.println("Change speed!");
            }
        };

        bicycle.move();
    }
}
