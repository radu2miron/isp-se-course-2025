package edu.tucn.ispse.lecture6.ex1collections.subex2set;

import java.util.Comparator;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class MyComparator implements Comparator<Ex2TreeSetExample.Human> {

    @Override
    public int compare(Ex2TreeSetExample.Human t1, Ex2TreeSetExample.Human t2) {
        return t1.getLastName().compareTo(t2.getLastName());
    }
}
