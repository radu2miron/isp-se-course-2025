package edu.tucn.ispse.lecture7.iostreams;

import java.io.*;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Ex3ObjectSerialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        if (args.length == 0) {
            System.err.println("Please set args[0]: 'save' or 'read'");
        } else if (args[0].equals("save")) {
            // write object to file
            Person p = new Person("12345", "Mircea", "Pop", 23);
            try (ObjectOutputStream oop =
                         new ObjectOutputStream(new FileOutputStream("testfiles/person.dat"))) {
                oop.writeObject(p);
            }
        } else if (args[0].equals("read")) {
            // read object from file
            try (ObjectInputStream oop =
                              new ObjectInputStream(new FileInputStream("testfiles/person.dat"))) {
                Person p = (Person) oop.readObject();
                System.out.println(p);
            }
        } else {
            System.err.println("Invalid argument!");
        }
    }

    private static class Person implements Serializable {
        private String pin;
        private String firstName;
        private String lastName;
        private transient int age;

        public Person(String pin, String firstName, String lastName, int age) {
            this.pin = pin;
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "pin=" + pin +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
