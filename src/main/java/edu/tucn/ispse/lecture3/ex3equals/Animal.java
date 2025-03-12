package edu.tucn.ispse.lecture3.ex3equals;

import java.util.Objects;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Animal {
    private String name;
    private int strength;

    public Animal(String name) {
        this.name = name;
    }

    public Animal(String name, int strength) {
        this(name);
        this.strength = strength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return strength == animal.strength && Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, strength);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", strength=" + strength +
                '}';
    }
}
