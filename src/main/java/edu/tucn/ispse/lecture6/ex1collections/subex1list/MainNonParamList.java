package edu.tucn.ispse.lecture6.ex1collections.subex1list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class MainNonParamList {
    public static void main(String[] args) {
        // mixed object types - it's not such a good idea
        List list = new ArrayList();
        // ADD
        list.add("abcd");
        list.add(new Person("123", "John", "Doe", "12 Abc St, DC"));
        list.add(123);
        list.add(12);
        list.add("deletable");

        // REMOVE
        Object lastElement = list.remove(list.size() - 1);

        // GET
        System.out.println(list.get(0).getClass());
        System.out.println(list.get(1).getClass());

        String s = (String) list.get(0); // type cast needed
        Person p = (Person) list.get(1); // type cast needed
        // etc.

//        list.get(5);

        // sum the integers in the list
        int sum = 0;

        // ITERATE
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);

            if (obj instanceof Integer) {
                sum += (Integer) obj; // type cast needed
            }
        }
        // or
        for (Object obj : list) {
            if (obj instanceof Integer) {
                sum += (Integer) obj; // type cast needed
            }
        }

        System.out.println("sum=" + sum);

        List list2 = new ArrayList();
        list2.add(123);
        list2.add(2);
        list2.add(3);
        list2.add(4);

        int[] sum2 = {0};
        list.forEach(el -> sum2[0] += (Integer) el);

        System.out.println(sum2[0]);

        // Anytime you find yourself writing code of the form "if the object is of type T1,
        // then do something, but if it's of type T2, then do something else," slap yourself.
        // (Effective C++, by Scott Meyers)
    }
}
