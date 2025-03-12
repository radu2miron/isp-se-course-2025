package edu.tucn.ispse.lecture3.ex2polymorphism.wpoly;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class BMW extends Car {
    public BMW() {
        super(BMW.class.getName());
    }

    @Override
    public void go() {
        System.out.println(super.getDisplayName() + " goes faster");
    }
}
