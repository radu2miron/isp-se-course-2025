package edu.tucn.ispse.lecture14.ex1S;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Ex1NonCompliant {
    public static void main(String[] args) throws IOException {
        PersonNC person = new PersonNC(123, "Jane Doe", "1st M St., New-Dej");
        person.serializePerson();
    }
}

class PersonNC {
    private int id;
    private String name;
    private String address;

    public PersonNC(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // TODO: this class is not compliant with SCP because it should not serialize itself;
    public void serializePerson() throws IOException {
        Gson gson = new Gson();
        Files.writeString(Path.of("testfiles/" + id + ".json"), gson.toJson(this));
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
        PersonNC person = (PersonNC) o;
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