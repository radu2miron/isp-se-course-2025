package edu.tucn.ispse.lecture6.ex1collections.subex2set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Ex2TreeSetExample {
    public static void main(String[] args) {
        Set<Human> humans = new HashSet<>();
        humans.add(new Human("Carles", "Puyol"));
        humans.add(new Human("Xavier", "Seven"));
        humans.add(new Human("Andy", "Test"));
        humans.add(new Human("Armin", "Cole"));
        print("HashSet", humans);

        // sort by first name - Human is comparable by first name
        Set<Human> humansSortedFistName = new TreeSet<>();
        humansSortedFistName.addAll(humans);
        print("TreeSet - sorted by first name", humansSortedFistName);

        // sort by last name - with a comparator
        TreeSet<Human> humansSortedLastName = new TreeSet<>(new MyComparator());
        humansSortedLastName.addAll(humans);
        print("TreeSet - sorted by last name", humansSortedLastName);
    }

    static void print(String what, Set<Human> humans) {
        System.out.println(what);

        for (Human human : humans) {
            System.out.println(human);
        }

        System.out.println();
    }

    public static class Human implements Comparable<Human> {
        private String firstName;
        private String lastName;

        public Human(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Human human = (Human) o;
            return Objects.equals(firstName, human.firstName) &&
                    Objects.equals(lastName, human.lastName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName);
        }

        @Override
        public String toString() {
            return firstName + " " + lastName;
        }

        @Override
        public int compareTo(Human o) {
            return this.firstName.compareTo(o.firstName);
        }

        public String getLastName() {
            return lastName;
        }
    }
}
