package edu.tucn.ispse.lecture6.ex1collections.subex2set;

import java.util.LinkedHashSet;
import java.util.Set;

import static edu.tucn.ispse.lecture6.ex1collections.subex2set.Ex2TreeSetExample.print;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Ex3LinkedHashSetExample {
    public static void main(String[] args) {
        Set<Ex2TreeSetExample.Human> humans = new LinkedHashSet<>();
        humans.add(new Ex2TreeSetExample.Human("Carles", "Puyol"));
        humans.add(new Ex2TreeSetExample.Human("Xavier", "Seven"));
        humans.add(new Ex2TreeSetExample.Human("Andy", "Test"));
        humans.add(new Ex2TreeSetExample.Human("Armin", "Cole"));
        print("LinkedHashSet", humans);
    }
}
