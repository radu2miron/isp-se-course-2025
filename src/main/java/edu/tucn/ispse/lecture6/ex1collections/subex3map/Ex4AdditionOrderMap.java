package edu.tucn.ispse.lecture6.ex1collections.subex3map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Ex4AdditionOrderMap {
    public static void main(String[] args) {
        Map<String, String> linkedMap = new LinkedHashMap<>();
        linkedMap.put("C", "test1");
        linkedMap.put("A", "test2");
        linkedMap.put("D", "test3");
        linkedMap.put("B", "test4");
        linkedMap.put("X", "test4");

        // show all key-value pairs
        linkedMap.forEach((k, v) -> System.out.println(k + ": " + v));

        // get one value
        System.out.println("got X->" + linkedMap.get("X"));

        // remove one pair
        System.out.println("remove X->" + linkedMap.remove("X"));
        System.out.println("search X-> " + linkedMap.get("X"));
    }
}
