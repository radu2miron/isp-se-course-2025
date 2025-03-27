package edu.tucn.ispse.lecture6.ex1collections.subex1list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class ZMainListIterator {
    public static void main(String[] args) {
        // todo: remove all Johns from the list

        System.out.println("Iterate and remove with: 1. forEach, 2. iterator");
        int choice = new Scanner(System.in).nextInt();

        List<Person> list = new ArrayList<>();
        list.add(new Person("111", "Mike", "White", "1 Short St"));
        list.add(new Person("123", "John", "Doe", "2 Long St"));
        list.add(new Person("456", "Jane", "Doe", "3 Black St"));
        list.add(new Person("444", "Matt", "Smith", "4 White St"));
        list.add(new Person("789", "John", "Brown", "2 Long St"));

        System.out.println("initial list size: " + list.size());

        switch (choice) {
            case 1:
                for (Person person : list) {
                    if (person.getFirstName().equals("John")) {
                        list.remove(person);
                    }
                }

            case 2:
                Iterator<Person> iterator = list.iterator();

                while (iterator.hasNext()) {
                    Person person = iterator.next();

                    if (person.getFirstName().equals("John")) {
                        iterator.remove();
                    }
                }

                // alternatives:
                // 1. add to aux list, then remove all after iteration; ex: list.removeAll(auxList)
                // 2. list.removeIf(p -> p.getFirstName().equals("John"));
                break;
            default:
                throw new IllegalArgumentException("Wrong choice!");
        }

        System.out.println("after removal list size: " + list.size());
    }
}
