package edu.tucn.ispse.lecture6.ex2exceptions;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Ex2UncheckedExceptionExample {
    public static void main(String[] args) {
        // NullPointerException
//        Object a = null;
//        System.out.println(a.equals(new Object()));

        // ArrayIndexOutOfBoundsException
//        List<String> l = Arrays.asList("abc", "def");
//        System.out.println(l.get(2));

        // ArithmeticException
        int res = 5 / 0;
        System.out.println(res);

        System.out.println("sdbhfa");
        System.out.println("sdbhfa");
        System.out.println("sdbhfa");
        System.out.println("sdbhfa");
    }
}
