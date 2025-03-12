package edu.tucn.ispse.lecture3.ex1encapsulation;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Main {
    public static void main(String[] args) {
        Person person = new Person("181-12-1234", "Mario", "Fusco", 49);
        person.age = 50; // todo: accessing data directly is not OK; fix it!
        System.out.println(person);
    }
}
