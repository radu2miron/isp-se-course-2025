package edu.tucn.ispse.lecture7.streamapi;

import java.util.List;
import java.util.Optional;

/**
 * @author Radu Miron
 * @version 1
 */
public class Ex3Optional {
    public static void main(String[] args) {
        Optional<String> optional =
                List.of("abc", "efg", "hijkq", "lmno", "prstu").stream() // create a stream of strings
                        .filter(s -> s.length() > 4) // keep only those with length > 4
                        .findAny(); // or .findFirst()

        // further map and/or filter an optional
        Optional<Integer> optionalInt = optional.map(s -> s.hashCode()); // transform string if it is present
        optional.ifPresent(System.out::println); // print if optional is present
        Optional<Integer> optionalInt1 = optionalInt.filter(i -> i % 10 == 0); // further filter the optional string
        optionalInt1.ifPresentOrElse(i -> System.out.println(i * 2), // print number * 2 if optional is not empty
                () -> System.out.println("not found")); // print message if optional is empty

        // if optional is empty provide an alternative
        String s1 = optional.orElse(":|"); // return ':|' if optional is empty
        String s2 = optional.orElseGet(() -> { // similar with .orElse() but you can also execute some code before returning the alternative
            System.out.println("String not found, returning ':)'");
            return ":)";
        });
        String s3 = optional.orElseThrow( // will throw an exception if optional is empty
                () -> new RuntimeException("String not found"));
        System.out.println(s1 + "-" + s2 + "-" + s3);

        // if optional is present do something with it
        optional.ifPresent(s -> System.out.println(s.length())); // perform an action if optional is not empty (print length of string)
        optional.ifPresentOrElse(System.out::println, // perform an action if optional is not empty (print string)
                () -> System.out.println("String not found")); // perform another action if optional is empty

        // check if it's empty or present
        boolean empty = optional.isEmpty();
        boolean present = optional.isPresent();
        System.out.println("is empty?" + empty + "; is present?" + present);
    }
}
