package edu.tucn.ispse.lecture6.ex1collections.subex5queue;

import java.util.ArrayDeque;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class LIFOExample {
    public static void main(String[] args) {
        ArrayDeque<String> lifo = new ArrayDeque<>();

        lifo.offerFirst("1");
        lifo.offerFirst("1");
        lifo.offerFirst("2");
        lifo.offerFirst("3");

        int lifoSize = lifo.size();

        for (int i = 0; i < lifoSize; i++) {
            System.out.println(lifo.pop());
        }
    }
}
