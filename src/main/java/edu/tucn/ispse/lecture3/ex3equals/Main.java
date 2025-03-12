package edu.tucn.ispse.lecture3.ex3equals;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Animal("cat", 2);
        Animal animal2 = new Animal("dog", 10);
        Animal animal3 = animal1;
        Animal animal4 = new Animal("cat", 2);

        System.out.println(animal4);

        System.out.println("animal1 == animal2? " + (animal1 == animal2)); //false
        System.out.println("animal1 == animal3? " + (animal1 == animal3)); //true
        System.out.println("animal1 == animal4? " + (animal1 == animal4)); //false
        System.out.println("animal1.equals(animal4)? " + animal1.equals(animal4)); //false if 'equals()' is not implemented in Animal
        System.out.println("animal1.equals(animal3)? " + animal1.equals(animal3)); //true even if 'equals()' is not implemented in Animal
                                                                                   //..by default, 'equals()' works as '=='
    }
}
