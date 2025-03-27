package edu.tucn.ispse.lecture6.ex1collections.subex3map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Ex2DictionaryWithCustomClassAsKey {
    public static void main(String[] args) {
        Map<Word, String> dictionary = new HashMap<>();

        int choice;
        Scanner scanner = new Scanner(in);

        do {
            System.out.println("1. Add\n2. Find\n3. Remove\n4. Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("word:");
                    Word word = new Word(readLine());

                    System.out.println("definition:");
                    String definition = readLine();

                    dictionary.put(word, definition);
                    System.out.println(word + " has been added to the dictionary");

                    break;
                case 2:
                    System.out.println("word:");
                    word = new Word(readLine());
                    System.out.println("definition:" + dictionary.get(word));

                    break;
                case 3:
                    System.out.println("word:");
                    word = new Word(readLine());
                    System.out.println("removed -> " + word + ": "+ dictionary.get(word));
            }
        } while (choice != 4);
    }

    static class Word { // THIS CLASS IS USED AS A KEY IN A MAP;
        // TODO: REMEMBER! It is very important to override equals() and hashCode().
        // TODO: REMEMBER! Use the same attributes for generating equals() and hashCode()!
        private String value;

        public Word(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Word word = (Word) o;
            return Objects.equals(value, word.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

    public static String readLine(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
