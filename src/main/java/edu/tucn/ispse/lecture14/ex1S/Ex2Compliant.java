package edu.tucn.ispse.lecture14.ex1S;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Ex2Compliant {
    public static void main(String[] args) throws IOException {
        Person person = new Person(456, "John Doe", "New-Cluj");
        PersonSerializer personSerializer = new PersonSerializer();
        personSerializer.serializePerson(person);
    }
}

class Person {
    private int id;
    private String name;
    private String address;

    public Person(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

class PersonSerializer {
    public void serializePerson(Person person) throws IOException {
        Gson gson = new Gson();
        Files.writeString(Path.of("testfiles/" + person.getId() + ".json"), gson.toJson(person));
    }
}
