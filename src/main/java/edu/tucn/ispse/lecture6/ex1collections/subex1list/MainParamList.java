package edu.tucn.ispse.lecture6.ex1collections.subex1list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class MainParamList {
    public static void main(String[] args) {
        // list of strings
        List<String> strings = new ArrayList<>();
        strings.add("ccc");
        strings.add("aaa");
        strings.add("bbb");
        strings.add("bbb");
        strings.add("bbb");
        strings.add("bbb");
        String string1 = strings.get(1); // no type cast needed
        System.out.println("The first string in list: " + string1);

        System.out.println("Unsorted 'strings':");
        strings.forEach(s -> System.out.println(s));
        System.out.println();

        Collections.sort(strings);

        System.out.println("Sorted 'strings':");
        strings.forEach(s -> System.out.println(s));
        System.out.println();

        System.out.println("Shuffled 'strings':");
        Collections.shuffle(strings);
        System.out.println();
        strings.forEach(s -> System.out.println(s));

        //list of integers
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.remove(2);

        int sum = 0;
        for (Integer i : integers) {
            sum += i; // no type cast needed
        }
        System.out.println("sum=" + sum);

        integers.stream()
                .reduce((a, b) -> a + b)
                .ifPresent(fSum -> System.out.println("functional sum = " + fSum));

        int sum1 = integers.stream()
                .filter(Objects::nonNull)
                .mapToInt(i -> i)
                .sum();
        System.out.println("sum1=" + sum1);

        //list of custom class
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("000", "John", "Doe", "12 Abc St, DC"));
        persons.add(new Person("000", "Jane", "Doe", "12 Abc St, DC"));
        persons.add(new Person("456", "Jane", "Doe", "12 Abc St, DC"));
        persons.add(new Person("001", "Abigail", "Doe", "12 Abc St, DC"));
        persons.add(new Person("003", "Abigail", "Doe", "12 Abc St, DC"));
        persons.add(new Person("002", "Abigail", "Doe", "12 Abc St, DC"));
        persons.add(new Person("004", "Abigail", "Doe", "12 Abc St, DC"));
        Person person1 = persons.get(0); // no type cast needed
        System.out.println(person1);

        // TODO: show how to sort this list also; sort by what?? - Comparable and Comparator
        Collections.sort(persons);
        System.out.println("sorted persons list by id number:");
        persons.forEach(p -> System.out.println(p.toString()));

        Collections.sort(persons, (o1, o2) -> {
            int r = o1.getFirstName().compareTo(o2.getFirstName());
            if (r == 0) {
                r = o1.getIdNumber().compareTo(o2.getIdNumber());
            }
            return r;
        });
        System.out.println("sorted persons list by first name:");
        persons.forEach(p -> System.out.println(p.toString()));
    }
}
