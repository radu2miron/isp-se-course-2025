package edu.tucn.ispse.lecture5.ex1interfaces;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Main {
    public static void main(String[] args) {
        Animal[] animals = {new Dog(), new Snake()};

        for (Animal animal : animals) {
            System.out.println("The animal is a " + animal.getClass().getSimpleName());
            animal.eat();
            animal.sleep();
            animal.communicate();
            System.out.println();
        }

        Animal.livesOn(); // static method implemented in the Animal interface
    }
}
