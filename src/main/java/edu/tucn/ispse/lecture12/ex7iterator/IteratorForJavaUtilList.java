package edu.tucn.ispse.lecture12.ex7iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class IteratorForJavaUtilList {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Marry");
        names.add("Egbert");
        names.add("John");

        java.util.Iterator<String> it = names.iterator();

        while (it.hasNext()) {
            String name = it.next();

            if (name.equals("Egbert")) {
                it.remove();
                System.out.println("removed " + name);
            } else {
                System.out.println(name);
            }
        }
    }
}
