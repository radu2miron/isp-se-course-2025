package edu.tucn.ispse.lecture6.ex1collections.subex3map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class SameHash {
    public static void main(String[] args) {
        System.out.println("Aa hashCode = " + "Aa".hashCode());
        System.out.println("BB hashCode = " + "BB".hashCode());

        Map<String, String> testSameHash = new HashMap<>();
        testSameHash.put("Aa", "val1");
        testSameHash.put("BB", "val2");
        testSameHash.put("BB", "val3");

        System.out.println("Get values: ");
//        System.out.println("Aa -> " + testSameHash.get("Aa"));
        System.out.println("BB -> " + testSameHash.get("BB"));
    }
}
