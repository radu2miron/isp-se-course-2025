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

        Map<String, String> testSameHashMap = new HashMap<>();
        testSameHashMap.put("Aa"/*key2*/, "val1");
        testSameHashMap.put("BB"/*key3*/, "val2");
//        testSameHashMap.put("BB"/*key2*/, "val3");

        System.out.println("Get values: ");
//        System.out.println("Aa -> " + testSameHashMap.get("Aa"));
//        System.out.println("BB -> " + testSameHashMap.get("BB"));

        testSameHashMap.forEach((k,v)-> System.out.println(k+"->"+v));
    }
}
