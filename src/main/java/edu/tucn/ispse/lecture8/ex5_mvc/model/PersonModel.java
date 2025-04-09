package edu.tucn.ispse.lecture8.ex5_mvc.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class PersonModel {
    private List<Person> persons;

    public PersonModel() {
        persons = new ArrayList<>();
    }

    public void addPerson(int id, String firstName, String lastName) {
        Person person = new Person(id, firstName, lastName);
        persons.add(person);
    }

    public List<Person> getPersons() {
        return persons;
    }
}
