package edu.tucn.ispse.lecture2.ex2;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Main {
    public static void main(String[] args) {
        int a = 5;
        int b = a; // assignment by value
        a++; // increment a
        System.out.println(b); // b is not incremented
    }
}
