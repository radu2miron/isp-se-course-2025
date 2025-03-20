package edu.tucn.ispse.lecture5.ex5record.ex53;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Main {
    public static void main(String[] args) {
        Address address = new Address("5 Flower Street", "Cluj-Napoca");
        Person person = new Person("John Doe", 23, address);

        System.out.println(person);
    }
}
