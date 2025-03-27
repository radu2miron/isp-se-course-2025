package edu.tucn.ispse.lecture6.ex1collections.subex3map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Ex3SortedMap {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("BB", "definition1");
        dictionary.put("Aa", "definition2");
        dictionary.put("T", "definition3");
        dictionary.put("CDE", "definition4");
        dictionary.put("1", "definition5");
        dictionary.put("2", "definition6");
        System.out.println("Dictionary with HashMap:");
        dictionary.forEach((k, v) -> System.out.println(k + ": " + v));

        System.out.println();

        Map<String, String> sortedDictionary = new TreeMap();
        sortedDictionary.putAll(dictionary);

        System.out.println("Dictionary with TreeMap:");

        for (Map.Entry<String, String> kv : sortedDictionary.entrySet()) {
            System.out.println(kv.getKey() + ": " + kv.getValue());
        }

        System.out.println();

        // get one value
        System.out.println("got T -> " + sortedDictionary.get("T"));

        // remove one pair
        System.out.println("removed T -> " + sortedDictionary.remove("T"));
        System.out.println("search T -> " + sortedDictionary.get("T"));
    }
}
