package edu.tucn.ispse.lecture5.ex1interfaces;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Dog implements Animal {
    @Override
    public void sleep() {
        System.out.println("The dog sleeps with eyes closed");
    }

    @Override
    public void eat() {
        System.out.println("The dog eats meat");
    }
}
