package edu.tucn.ispse.lecture6.ex2exceptions;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Ex3Errors {
    public static void a() {
        System.out.println("this is 'a()'");
        b();
    }

    public static void b() {
        System.out.println("this is 'b()'");
        a();
    }

    public static void c() {
        System.out.println("this is 'c()'");
        c();
    }

    public static void main(String[] args) {
        a(); // or call c();
//        c();
    }
}
